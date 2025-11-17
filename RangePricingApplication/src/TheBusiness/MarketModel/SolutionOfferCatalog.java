/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.MarketModel;

import TheBusiness.ProductManagement.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class SolutionOfferCatalog {

    private List<SolutionOffer> offerList;

    public SolutionOfferCatalog() {
        this.offerList = new ArrayList<>();
    }

    public SolutionOffer addOffer(MarketChannelAssignment combo, Product p, double actualPrice) {
        SolutionOffer so = new SolutionOffer(combo, p, actualPrice);
        offerList.add(so);
        return so;
    }

    public List<SolutionOffer> getOfferList() {
        return offerList;
    }

    /**
     * Adjusts product prices downward if actual < target.
     */
    public void adjustTargetPriceDown() {
        for (SolutionOffer offer : offerList) {
            Product p = offer.getProduct();
            if (offer.getActualPrice() < p.getTargetPrice()) {
                p.setTargetPrice(p.getTargetPrice() - 0.05 * p.getTargetPrice());
            }
        }
    }

    /**
     * Adjusts product prices upward if actual > target.
     */
    public void adjustTargetPriceUp() {
        for (SolutionOffer offer : offerList) {
            Product p = offer.getProduct();
            if (offer.getActualPrice() > p.getTargetPrice()) {
                p.setTargetPrice(p.getTargetPrice() + 0.05 * p.getTargetPrice());
            }
        }
    }

    /**
     * Simulates revenue calculation across all offers.
     */
    public double runRevenueSimulation() {
        double totalRevenue = 0.0;
        for (SolutionOffer offer : offerList) {
            double randomQty = 10 + (Math.random() * 90); // 10 to 100
            offer.updateRevenue(randomQty);
            totalRevenue += offer.getRevenueGenerated();
        }
        return totalRevenue;
    }

}
