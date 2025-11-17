/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.OrderManagement;

/**
 *
 * @author kal bugrara
 */
public class OrderSummary {
    private Order order;

    public OrderSummary(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public double getOrderTotal() {
        return order.getOrderTotal();
    }

    public String getCustomerName() {
        return order.getCustomer().getPerson().getName();
    }

    public String getSalesPersonName() {
        return order.getSalesPerson().getPerson().getName();
    }

}
