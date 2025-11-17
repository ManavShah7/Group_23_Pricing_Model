/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.CustomerManagement;

import TheBusiness.OrderManagement.Order;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kal bugrara
 */
public class CustomersReport {
    private Map<CustomerProfile, CustomerSummary> summaryMap;

    public CustomersReport() {
        this.summaryMap = new HashMap<>();
    }

    private CustomerSummary getOrCreateSummary(CustomerProfile cp) {
        CustomerSummary cs = summaryMap.get(cp);
        if (cs == null) {
            cs = new CustomerSummary(cp);
            summaryMap.put(cp, cs);
        }
        return cs;
    }

    public void buildFromOrders(List<Order> orders) {
        summaryMap.clear();
        for (Order o : orders) {
            CustomerSummary cs = getOrCreateSummary(o.getCustomer());
            cs.registerOrder(o);
        }
    }

    public List<CustomerSummary> getCustomerSummaries() {
        return new ArrayList<>(summaryMap.values());
    }
}
