/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarketAnalytics;

import TheBusiness.MarketModel.Market;
import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;

/**
 *
 * @author kal bugrara
 */
public class MarketSummary {
    private Market market;
    private int unitsSold;
    private double totalRevenue;

    public MarketSummary(Market market) {
        this.market = market;
    }

    public void registerOrder(Order order) {
        for (OrderItem item : order.getOrderItems()) {
            unitsSold += item.getQuantity();
            totalRevenue += item.getItemTotal();
        }
    }

    public Market getMarket() {
        return market;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }
                
    }
    
