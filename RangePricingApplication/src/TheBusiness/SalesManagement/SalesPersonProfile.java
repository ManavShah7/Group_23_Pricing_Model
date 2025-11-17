/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.SalesManagement;

import java.util.ArrayList;
import TheBusiness.OrderManagement.Order;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.Profile;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class SalesPersonProfile extends Profile {
    private List<Order> processedOrders;

    public SalesPersonProfile(Person person) {
        super(person);
        this.processedOrders = new ArrayList<>();
    }

    public void addProcessedOrder(Order o) {
        processedOrders.add(o);
    }

    public int getTotalOrdersProcessed() {
        return processedOrders.size();
    }

    @Override
    public String toString() {
        return "SalesPerson: " + person.getName();
    }

}
