/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarketAnalytics;

import TheBusiness.MarketModel.Channel;
import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;

/**
 *
 * @author kal bugrara
 */
public class ChannelSummary {
    private Channel channel;
    private int unitsSold;
    private double totalRevenue;

    public ChannelSummary(Channel channel) {
        this.channel = channel;
    }

    public void registerOrder(Order order) {
        for (OrderItem item : order.getOrderItems()) {
            unitsSold += item.getQuantity();
            totalRevenue += item.getItemTotal();
        }
    }

    public Channel getChannel() {
        return channel;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }
}
