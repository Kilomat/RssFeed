package model;

import java.util.List;

/**
 * Created by BAHA on 29/01/2017.
 */
public class ChannelResult {
    private List<ChannelInfo> results;

    public ChannelResult(List<ChannelInfo> results) {
        this.results = results;
    }

    public List<ChannelInfo> getResults() {
        return results;
    }
}