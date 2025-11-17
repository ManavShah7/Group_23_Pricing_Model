/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.MarketModel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class ChannelCatalog {
    
    private List<Channel> channelList;

    public ChannelCatalog() {
        this.channelList = new ArrayList<>();
    }

    public Channel addChannel(String name) {
        Channel c = new Channel(name);
        channelList.add(c);
        return c;
    }

    public List<Channel> getChannelList() {
        return channelList;
    }

    public Channel findChannel(String name) {
        for (Channel c : channelList) {
            if (c.getChannelName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }
    
    
}
