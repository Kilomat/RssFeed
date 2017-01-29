package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by BAHA on 29/01/2017.
 */
public class ChannelInfo {

    @JsonProperty("id")
    public Long id;
    @JsonProperty("title")
    public String title;
    @JsonProperty("link")
    public List<Link> link;
    @JsonProperty("description")
    public String description;
    @JsonProperty("language")
    public String language;
    @JsonProperty("image")
    public Thumbnail thumbnail;
    @JsonProperty("article_number")
    public Integer article_number;

    public ChannelInfo() {
        super();
    }

    /*
    @JsonProperty("id")
    public String id;
    @JsonProperty("title")
    public String title;
    @JsonProperty("link")
    public String link;
    @JsonProperty("description")
    public String description;
    @JsonProperty("language")
    public String language;
    @JsonProperty("article_number")
    public String article_number;

    public ChannelInfo(String title, String link, String description,
                       String language, String article_number) {

        this.link = link;
        this.title = title;
        this.description = description;
        this.language = language;
        this.article_number = article_number;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(String link){
        this.link = link;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    public void setArticle_number(String article_number){
        this.article_number = article_number;
    }
    public String getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public String getArticleNumber() {
        return article_number;
    }
    */
}