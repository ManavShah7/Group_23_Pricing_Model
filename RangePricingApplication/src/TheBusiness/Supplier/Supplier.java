/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.Supplier;

import TheBusiness.ProductManagement.ProductCatalog;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class Supplier {

    private String supplierId;
    private String supplierName;
    private ProductCatalog productCatalog;

    public Supplier(String supplierName) {
        this.supplierId = java.util.UUID.randomUUID().toString();
        this.supplierName = supplierName;
        this.productCatalog = new ProductCatalog(this);
    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    @Override
    public String toString() {
        return supplierName;
    }
}
