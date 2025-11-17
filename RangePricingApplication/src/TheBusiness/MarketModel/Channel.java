/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.MarketModel;

/**
 *
 * @author kal bugrara
 */
public class Channel {
    private String channelId;
    private String channelName;

    public Channel(String name) {
        this.channelId = java.util.UUID.randomUUID().toString();
        this.channelName = name;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public String toString() {
        return channelName;
    }
}
