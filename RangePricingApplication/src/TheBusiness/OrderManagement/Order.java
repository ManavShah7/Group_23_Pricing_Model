/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.OrderManagement;

import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.ProductManagement.Product;
import TheBusiness.SalesManagement.SalesPersonProfile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class Order {

    private CustomerProfile customer;
    private SalesPersonProfile salesPerson;
    private MarketChannelAssignment marketChannelAssignment;
    private List<OrderItem> orderItems;

    public Order(CustomerProfile customer,
            SalesPersonProfile salesPerson,
            MarketChannelAssignment assignment) {
        this.customer = customer;
        this.salesPerson = salesPerson;
        this.marketChannelAssignment = assignment;
        this.orderItems = new ArrayList<>();
    }

    public CustomerProfile getCustomer() {
        return customer;
    }

    public SalesPersonProfile getSalesPerson() {
        return salesPerson;
    }

    public MarketChannelAssignment getMarketChannelAssignment() {
        return marketChannelAssignment;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public OrderItem addOrderItem(Product product, int quantity, double actualPrice) {
        OrderItem oi = new OrderItem(product, quantity, actualPrice);
        orderItems.add(oi);
        return oi;
    }

    public double getOrderTotal() {
        double sum = 0.0;
        for (OrderItem oi : orderItems) {
            sum += oi.getItemTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Order for " + customer.getPerson().getName() + " | Items: " + orderItems.size();
    }
}
