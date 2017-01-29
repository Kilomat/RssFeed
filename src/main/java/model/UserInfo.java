package model;

/**
 * Created by BAHA on 29/01/2017.
 */

public class UserInfo {

    public Integer id;
    public Integer Token;
    public String Username;
    public String Password;


    public UserInfo(Integer id, Integer Token, String Username, String Password) {

        this.Token = Token;
        this.id = id;
        this.Username = Username;
        this.Password = Password;
    }

    public Integer getId() {
        return Token;
    }

    public Integer getToken() {
        return id;
    }

    /*public String getUsername() {
        return Username;
    }

    public String getUsername() {
        return Password;
    }*/

}