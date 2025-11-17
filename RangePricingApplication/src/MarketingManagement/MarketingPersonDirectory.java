/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarketingManagement;

import java.util.ArrayList;
import TheBusiness.Personnel.Person;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class MarketingPersonDirectory {

    private List<MarketingPersonProfile> marketingPersons;

    public MarketingPersonDirectory() {
        this.marketingPersons = new ArrayList<>();
    }

    public MarketingPersonProfile addMarketingPerson(Person p) {
        MarketingPersonProfile mp = new MarketingPersonProfile(p);
        marketingPersons.add(mp);
        return mp;
    }

    public List<MarketingPersonProfile> getMarketingPersons() {
        return marketingPersons;
    }

    public MarketingPersonProfile findMarketingPersonByName(String name) {
        for (MarketingPersonProfile mp : marketingPersons) {
            if (mp.getPerson().getName().equalsIgnoreCase(name)) {
                return mp;
            }
        }
        return null;
    }

}
