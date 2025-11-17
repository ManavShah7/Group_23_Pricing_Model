/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.CustomerManagement;

import TheBusiness.Personnel.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class CustomerDirectory {

    private List<CustomerProfile> customerList;

    public CustomerDirectory() {
        this.customerList = new ArrayList<>();
    }

    public CustomerProfile addCustomer(Person person) {
        CustomerProfile cp = new CustomerProfile(person);
        customerList.add(cp);
        return cp;
    }

    public List<CustomerProfile> getCustomerList() {
        return customerList;
    }

    public CustomerProfile findCustomerByPerson(Person p) {
        for (CustomerProfile cp : customerList) {
            if (cp.getPerson().equals(p)) {
                return cp;
            }
        }
        return null;
    }
}
