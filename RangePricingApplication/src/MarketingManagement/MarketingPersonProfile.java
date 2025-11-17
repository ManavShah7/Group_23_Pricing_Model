/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarketingManagement;

import java.util.ArrayList;
import TheBusiness.OrderManagement.Order;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.Profile;

/**
 *
 * @author kal bugrara
 */
public class MarketingPersonProfile extends Profile {
    private int campaignsRun;
    private int priceAdjustments;

    public MarketingPersonProfile(Person person) {
        super(person);
        this.campaignsRun = 0;
        this.priceAdjustments = 0;
    }

    public void recordCampaign() {
        campaignsRun++;
    }

    public void recordPriceAdjustment() {
        priceAdjustments++;
    }

    public int getCampaignsRun() {
        return campaignsRun;
    }

    public int getPriceAdjustments() {
        return priceAdjustments;
    }

    @Override
    public String toString() {
        return "MarketingPerson: " + person.getName();
    }

}
