/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.MarketModel;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class Market {

    private String marketId;
    private String marketName;
    private String description;

    public Market(String name, String description) {
        this.marketId = java.util.UUID.randomUUID().toString();
        this.marketName = name;
        this.description = description;
    }

    public String getMarketId() {
        return marketId;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return marketName;
    }
    

}
