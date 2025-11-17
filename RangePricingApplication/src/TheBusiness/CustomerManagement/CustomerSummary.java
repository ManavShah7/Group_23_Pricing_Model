/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.CustomerManagement;

import TheBusiness.OrderManagement.Order;

/**
 *
 * @author kal bugrara
 */
public class CustomerSummary {
    private CustomerProfile customer;
    private int totalOrders;
    private double totalRevenue;

    public CustomerSummary(CustomerProfile customer) {
        this.customer = customer;
    }

    public void registerOrder(Order order) {
        totalOrders++;
        totalRevenue += order.getOrderTotal();
    }

    public CustomerProfile getCustomer() {
        return customer;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }
    
    
}
