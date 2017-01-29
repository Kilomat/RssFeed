package model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by BAHA on 29/01/2017.
 */

public class UserInfo {

    @JsonProperty("token")
    public String token;
    @JsonProperty("login")
    public String login;
    @JsonProperty("password")
    public String password;


    public UserInfo() {
        super();
    }

    public UserInfo(String Token, String Username, String Password) {

        this.token = Token;
        this.login = Username;
        this.password = Password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return login;
    }

    public void setToken(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}