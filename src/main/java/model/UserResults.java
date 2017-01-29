package model;

import java.util.List;

/**
 * Created by BAHA on 29/01/2017.
 */
public class UserResults {
    private List<UserInfo> results;

    public UserResults(List<UserInfo> results) {
        this.results = results;
    }

    public List<UserInfo> getResults() {
        return results;
    }
}