package org.neigbors.analitics.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by andrey on 16.11.14.
 */

public class ArticleSetDto implements Serializable {

    private List<ArticleDto> articles;

    private String description;

    public ArticleSetDto(String description, List<ArticleDto> articles) {
        this.articles = articles;
        this.description = description;
    }

    public ArticleSetDto() {
    }

    public List<ArticleDto> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleDto> articles) {
        this.articles = articles;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
