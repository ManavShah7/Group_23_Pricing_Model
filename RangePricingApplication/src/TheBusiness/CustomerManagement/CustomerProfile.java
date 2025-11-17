/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.CustomerManagement;

import java.util.ArrayList;
import TheBusiness.OrderManagement.Order;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.Profile;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class CustomerProfile extends Profile {

    private List<Order> orderList;

    public CustomerProfile(Person person) {
        super(person);
        this.orderList = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public int getTotalOrders() {
        return orderList.size();
    }

    @Override
    public String toString() {
        return "Customer: " + person.getName();
    }

}
