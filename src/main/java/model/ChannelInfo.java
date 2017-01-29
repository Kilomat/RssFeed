package model;

/**
 * Created by BAHA on 29/01/2017.
 */
public class ChannelInfo {

    public Integer id;
    public String title;
    public String link;
    public String description;
    public String language;
    public int article_number;

    public ChannelInfo(String title, String link, String description,
                       String language, Integer article_number) {

        this.link = link;
        this.title = title;
        this.description = description;
        this.language = language;
        this.article_number = article_number;
    }

    public Integer getId() {
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

    public Integer getArticleNumber() {
        return article_number;
    }
}