package view;

/**
 * Created by BAHA on 28/01/2017.
 */

public class LoginButtonEvent {

    private String login, passwd;

    public LoginButtonEvent(String login, String passwd) {
        this.login = login;
        this.passwd = passwd;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswd() {
        return passwd;
    }
}