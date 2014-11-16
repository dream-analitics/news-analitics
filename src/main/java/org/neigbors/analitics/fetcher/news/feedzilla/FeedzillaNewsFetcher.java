package org.neigbors.analitics.fetcher.news.feedzilla;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;
import org.codehaus.jackson.type.TypeReference;
import org.neigbors.analitics.dto.ArticleDto;
import org.neigbors.analitics.dto.ArticleSetDto;
import org.neigbors.analitics.dto.CategoryDto;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FeedzillaNewsFetcher {

    private ObjectMapper mapper;


    private final String ROOT_CATEGORIES_URL = "http://api.feedzilla.com/v1/categories";

    private final String DOT_JSON = ".json";

    private final String ARTICLES = "articles";


    {
        mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("category", new Version(1, 0, 0, ""));
        module.addDeserializer(CategoryDto.class, new FeedzillaCategoryDeserializer());
        mapper.registerModule(module);

        SimpleModule module1 = new SimpleModule("articleset", new Version(1, 0, 0, ""));
        module.addDeserializer(ArticleSetDto.class, new FeedzillaArticleSetDeserializer());
        mapper.registerModule(module);
    }

    public List<CategoryDto> getAllCategories(Order order) {
        URL url;

        try {
            url = bakeURL(ROOT_CATEGORIES_URL + DOT_JSON, order);
        } catch (MalformedURLException e) {
            // todo : logging framework
            e.printStackTrace();
            return Collections.emptyList();
        }

        List<CategoryDto> result = new ArrayList<CategoryDto>();
        try {
            result.addAll(
                    (List<CategoryDto>) mapper.readValue(
                            url,
                            new TypeReference<ArrayList<CategoryDto>>() {
                            })
            );
        } catch (IOException e) {
            // todo : logging framework
            e.printStackTrace();
            return Collections.emptyList();
        }

        return result;
    }

    private URL bakeURL(String baseUrl, Order order) throws MalformedURLException {
        if (order != null) {
            baseUrl += "?order=" + order.getCode();
        }
        return new URL(baseUrl);
    }

    public ArticleSetDto getArticlesForCategoryId(Integer categoryId, Integer count) {
        URL url;

        try {
            url = new URL(
                    ROOT_CATEGORIES_URL + '/' + categoryId + '/' + ARTICLES +  DOT_JSON + "?count=" + count
            );

        } catch (MalformedURLException e) {
            // todo : logging framework
            e.printStackTrace();
            return new ArticleSetDto("Exception :-( " + e.getLocalizedMessage(), Collections.<ArticleDto>emptyList());
        }

        ArticleSetDto result;
        try {
            result = mapper.readValue(
                            url,
                            ArticleSetDto.class);

        } catch (IOException e) {
            // todo : logging framework
            e.printStackTrace();
            return new ArticleSetDto("Exception :-(  " + e.getLocalizedMessage(), Collections.<ArticleDto>emptyList());
        }

        return result;
    }

    public static enum Order {

        POPULAR("popular"),
        NONE("none");

        private String code;
        Order(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}