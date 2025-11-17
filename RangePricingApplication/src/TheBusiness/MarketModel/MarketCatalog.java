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
public class MarketCatalog {

    private List<Market> marketList;

    public MarketCatalog() {
        this.marketList = new ArrayList<>();
    }

    public Market addMarket(String name, String description) {
        Market m = new Market(name, description);
        marketList.add(m);
        return m;
    }

    public List<Market> getMarketList() {
        return marketList;
    }

    public Market findMarket(String name) {
        for (Market m : marketList) {
            if (m.getMarketName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }

}
