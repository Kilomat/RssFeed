package model;

/**
 * Created by BAHA on 29/01/2017.
 */
import com.fasterxml.jackson.annotation.JsonProperty;

public class Link {
    @JsonProperty("href")
    public String href;
    @JsonProperty("rel")
    public String rel;
    @JsonProperty("link")
    public String link;
    @JsonProperty("content_type")
    public String content_type;
}