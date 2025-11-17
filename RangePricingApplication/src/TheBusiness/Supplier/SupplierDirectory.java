/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.Supplier;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class SupplierDirectory {

    private List<Supplier> supplierList;

    public SupplierDirectory() {
        this.supplierList = new ArrayList<>();
    }

    public List<Supplier> getSupplierList() {
        return supplierList;
    }

    public Supplier addSupplier(String name) {
        Supplier supplier = new Supplier(name);
        supplierList.add(supplier);
        return supplier;
    }

    public void removeSupplier(Supplier supplier) {
        supplierList.remove(supplier);
    }

    public Supplier findSupplierByName(String name) {
        for (Supplier s : supplierList) {
            if (s.getSupplierName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    public int size() {
        return supplierList.size();
    }

}
