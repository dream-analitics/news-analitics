package org.neigbors.analitics.fetcher.news.feedzilla;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.neigbors.analitics.dto.ArticleDto;
import org.neigbors.analitics.dto.ArticleSetDto;
import org.neigbors.analitics.dto.CategoryDto;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by andrey on 16.11.14.
 */
public class FeedzillaArticleSetDeserializer extends JsonDeserializer<ArticleSetDto> {


    private final String ID = "category_id";
    private final String DESCRIPTION = "description";
    private final String ARTICLES = "articles";
    private final String TITLE = "title";
    private final String SUMMARY = "summary";
    private final String DATE = "publish_date";

    private DateFormat df =
            new SimpleDateFormat("EEE, dd MMM yyyy kk:mm:ss ZZZZ", Locale.ENGLISH);


    @Override
    public ArticleSetDto deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);

        String description = node.get(DESCRIPTION).getTextValue();
        JsonNode articlesNode = node.get(ARTICLES);
        Iterator<JsonNode> articles = articlesNode.getElements();

        List<ArticleDto> articleDataList = new ArrayList<ArticleDto>();

        while (articles.hasNext()) {
            JsonNode article = articles.next();

            ArticleDto articleDto = new ArticleDto();
            articleDto.setTitle(article.get(TITLE).getTextValue());
            articleDto.setText(article.get(SUMMARY).getTextValue());
            articleDto.setTopic(description);
            try {
                articleDto.setDate(df.parse(article.get(DATE).getTextValue()) );
            } catch (ParseException e) {
                e.printStackTrace();
                // do nothing
            }
            articleDataList.add(articleDto);
        }

        return new ArticleSetDto(description, articleDataList);
    }
}