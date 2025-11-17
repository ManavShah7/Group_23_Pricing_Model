/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.SalesManagement;

import java.util.ArrayList;
import TheBusiness.Personnel.Person;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class SalesPersonDirectory {

    private List<SalesPersonProfile> salesPersons;

    public SalesPersonDirectory() {
        this.salesPersons = new ArrayList<>();
    }

    public SalesPersonProfile addSalesPerson(Person p) {
        SalesPersonProfile sp = new SalesPersonProfile(p);
        salesPersons.add(sp);
        return sp;
    }

    public List<SalesPersonProfile> getSalesPersons() {
        return salesPersons;
    }

    public SalesPersonProfile findSalesPersonByName(String name) {
        for (SalesPersonProfile sp : salesPersons) {
            if (sp.getPerson().getName().equalsIgnoreCase(name)) {
                return sp;
            }
        }
        return null;
    }

}
