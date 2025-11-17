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
public class MarketChannelComboCatalog {
    
    private List<MarketChannelAssignment> comboList;

    public MarketChannelComboCatalog() {
        this.comboList = new ArrayList<>();
    }

    public MarketChannelAssignment addCombo(Market m, Channel c) {
        MarketChannelAssignment combo = new MarketChannelAssignment(m, c);
        comboList.add(combo);
        return combo;
    }

    public List<MarketChannelAssignment> getComboList() {
        return comboList;
    }
}
