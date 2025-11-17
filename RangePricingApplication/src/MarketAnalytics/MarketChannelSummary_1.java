/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarketAnalytics;

import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;

/**
 *
 * @author kal bugrara
 */
public class MarketChannelSummary {
    private MarketChannelAssignment assignment;
    private int unitsSold;
    private double totalRevenue;

    public MarketChannelSummary(MarketChannelAssignment assignment) {
        this.assignment = assignment;
    }

    public void registerOrder(Order order) {
        for (OrderItem item : order.getOrderItems()) {
            unitsSold += item.getQuantity();
            totalRevenue += item.getItemTotal();
        }
    }

    public MarketChannelAssignment getAssignment() {
        return assignment;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

}
