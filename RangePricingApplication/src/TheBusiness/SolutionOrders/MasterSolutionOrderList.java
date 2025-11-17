/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.SolutionOrders;

import TheBusiness.MarketModel.SolutionOffer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class MasterSolutionOrderList {
     private List<SolutionOffer> executedOffers;

    public MasterSolutionOrderList() {
        this.executedOffers = new ArrayList<>();
    }

    public void addExecutedOffer(SolutionOffer so) {
        executedOffers.add(so);
    }

    public List<SolutionOffer> getExecutedOffers() {
        return executedOffers;
    }

    public double getTotalRevenue() {
        double sum = 0.0;
        for (SolutionOffer so : executedOffers) {
            sum += so.getRevenueGenerated();
        }
        return sum;
    }

    public int size() {
        return executedOffers.size();
    }

}
