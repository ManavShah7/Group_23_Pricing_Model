/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.ProductManagement;

import TheBusiness.Supplier.Supplier;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class ProductCatalog {

    private Supplier supplier;
    private List<Product> productList;

    public ProductCatalog(Supplier supplier) {
        this.supplier = supplier;
        this.productList = new ArrayList<>();
    }

    public Product addProduct(String name, double target, double floor, double ceiling) {
        Product p = new Product(name, target, floor, ceiling);
        productList.add(p);
        return p;
    }

    public void removeProduct(Product p) {
        productList.remove(p);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product findProductByName(String name) {
        for (Product p : productList) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

}
