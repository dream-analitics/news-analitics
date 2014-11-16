package org.neigbors.analitics.service.impl;

import org.neigbors.analitics.dto.ArticleDto;
import org.neigbors.analitics.dto.ArticleSetDto;
import org.neigbors.analitics.dto.CategoryDto;
import org.neigbors.analitics.fetcher.news.feedzilla.FeedzillaNewsFetcher;
import org.neigbors.analitics.service.ArticleService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DefaultArticleService implements ArticleService {

    @Resource
    private FeedzillaNewsFetcher feedzillaNewsFetcher;

    @Override
    public List<ArticleDto> fetchLatestNews() {
        return getDummyNews();
    }

    @Override
    public List<CategoryDto> fetchAllRootCategories() {
        return feedzillaNewsFetcher.getAllCategories(FeedzillaNewsFetcher.Order.POPULAR);
    }

    @Override
    public ArticleSetDto getArticlesByCategoryId(Integer categoryId, Integer count) {
        return feedzillaNewsFetcher.getArticlesForCategoryId(categoryId, count);
    }

    private List<ArticleDto> getDummyNews() {
        List<ArticleDto> result = new ArrayList<ArticleDto>(3);
        result.add(createArticle(
                "космос",
                "Модуль \"Фила\" сегодня может возобновить передачу данных с кометы",
                "Космический модуль \"Фила\", севший на комету Чурюмова - Герасименко, выполнил все свои задачи и перешел в спящий режим. Хотя сегодня в течение дня он может снова передавать данные с объекта." +
                        "Об этом говорится в заявлении  ученых Европейского космического агентства (ЕКА), передает РИА Новости.\n" +
                        "\n" +
                        "Переход в спящий режим связан с быстрой разрядкой батарей, так как модуль приземлился в тени образования, похожего на утес, это мешало аппарату подзаряжаться от солнца.  \"Но теперь контакт возможен, если будет достаточно солнечного света для батарей, чтобы сгенерировать достаточную мощность\", -отметили ученые.\n" +
                        "\n" +
                        "\"Окно\" для передачи данных должен быть открыто около 10 утра GMT (13.00 мск).\n" +
                        "\n" +
                        "Напомним, что впервые в истории человечества космический аппарат достиг поверхности кометы.", new Date()
        ));

        result.add(createArticle(
                "космос",
                "Модуль \"Фила\" сегодня может возобновить передачу данных с кометы",
                "Космический модуль \"Фила\", севший на комету Чурюмова - Герасименко, выполнил все свои задачи и перешел в спящий режим. Хотя сегодня в течение дня он может снова передавать данные с объекта." +
                        "Об этом говорится в заявлении  ученых Европейского космического агентства (ЕКА), передает РИА Новости.\n" +
                        "\n" +
                        "Переход в спящий режим связан с быстрой разрядкой батарей, так как модуль приземлился в тени образования, похожего на утес, это мешало аппарату подзаряжаться от солнца.  \"Но теперь контакт возможен, если будет достаточно солнечного света для батарей, чтобы сгенерировать достаточную мощность\", -отметили ученые.\n" +
                        "\n" +
                        "\"Окно\" для передачи данных должен быть открыто около 10 утра GMT (13.00 мск).\n" +
                        "\n" +
                        "Напомним, что впервые в истории человечества космический аппарат достиг поверхности кометы.", new Date()
        ));

        return result;
    }

    private ArticleDto createArticle(String topic, String title, String text, Date date) {
        ArticleDto article = new ArticleDto();
        article.setTopic(topic);
        article.setTitle(title);
        article.setText(text);
        article.setDate(date);
        return article;
    }
}
