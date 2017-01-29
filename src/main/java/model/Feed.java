package model;

/**
 * Created by BAHA on 29/01/2017.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

public class Feed {
    @JsonProperty
    public String title;

    @JsonProperty
    public String link;

    @JsonProperty(value = "comments_url")
    public String commentsUrl;

    @JsonProperty(value = "publication_date")
    public String publicationDate;

    @JsonProperty
    public String creator;

    @JsonProperty
    public String guid;

    @JsonProperty
    public String description;


    public Feed() {
        super();
    }
}