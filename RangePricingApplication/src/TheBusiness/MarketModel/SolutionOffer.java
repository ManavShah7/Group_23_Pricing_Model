/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.MarketModel;

import java.util.ArrayList;
import TheBusiness.ProductManagement.Product;
import TheBusiness.SolutionOrders.SolutionOrder;

/**
 *
 * @author kal bugrara
 */
public class SolutionOffer {
    private MarketChannelAssignment marketChannelCombo;
    private Product product;
    private double actualPrice;
    private double revenueGenerated;

    public SolutionOffer(MarketChannelAssignment combo, Product product, double actualPrice) {
        this.marketChannelCombo = combo;
        this.product = product;
        this.actualPrice = actualPrice;
        this.revenueGenerated = 0.0;
    }

    public MarketChannelAssignment getMarketChannelCombo() {
        return marketChannelCombo;
    }

    public Product getProduct() {
        return product;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public double getRevenueGenerated() {
        return revenueGenerated;
    }

    public void updateRevenue(double quantity) {
        this.revenueGenerated += actualPrice * quantity;
    }

    @Override
    public String toString() {
        return product.getName() + " @" + actualPrice + " (" + marketChannelCombo + ")";
    }

    
}
