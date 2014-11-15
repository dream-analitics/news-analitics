package org.neigbors.analitics.dto;

import java.util.Date;

/**
 * Class that represent an Article
 */
public class ArticleDto {

    private String title;
    private String topic;
    private String text;
    private Date date;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
