package model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by BAHA on 29/01/2017.
 */

public class UserInfo {

    @JsonProperty("id")
    public String id;
    @JsonProperty("token")
    public String token;
    @JsonProperty("login")
    public String username;
    @JsonProperty("password")
    public String password;


    public UserInfo() {
        super();
    }

    public UserInfo(String id, String Token, String Username, String Password) {

        this.token = Token;
        this.id = id;
        this.username = Username;
        this.password = Password;
    }

    public String getLogin() {
        return username;
    }

    public void setLogin(String login) {
        this.username = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}