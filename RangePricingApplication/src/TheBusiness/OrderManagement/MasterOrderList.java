/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.OrderManagement;

import java.util.ArrayList;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.SalesManagement.SalesPersonProfile;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class MasterOrderList {
    private List<Order> orders;

    public MasterOrderList() {
        this.orders = new ArrayList<>();
    }

    public Order addNewOrder(CustomerProfile customer,
                             SalesPersonProfile salesPerson,
                             MarketChannelAssignment assignment) {
        Order o = new Order(customer, salesPerson, assignment);
        orders.add(o);
        customer.addOrder(o);
        salesPerson.addProcessedOrder(o);
        return o;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public int size() {
        return orders.size();
    }

    public double getTotalRevenue() {
        double total = 0.0;
        for (Order o : orders) {
            total += o.getOrderTotal();
        }
        return total;
    }

}
