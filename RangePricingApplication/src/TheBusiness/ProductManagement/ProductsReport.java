/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.ProductManagement;

import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kal bugrara
 */
public class ProductsReport {

    private Map<Product, ProductSummary> productSummaryMap;

    public ProductsReport() {
        this.productSummaryMap = new HashMap<>();
    }

    private ProductSummary getOrCreateSummary(Product p) {
        ProductSummary ps = productSummaryMap.get(p);
        if (ps == null) {
            ps = new ProductSummary(p);
            productSummaryMap.put(p, ps);
        }
        return ps;
    }

    public void buildFromOrders(List<Order> orders) {
        productSummaryMap.clear();
        for (Order o : orders) {
            for (OrderItem item : o.getOrderItems()) {
                ProductSummary ps = getOrCreateSummary(item.getProduct());
                ps.registerSale(item);
            }
        }
    }

    public List<ProductSummary> getProductSummaries() {
        return new ArrayList<>(productSummaryMap.values());
    }
}
