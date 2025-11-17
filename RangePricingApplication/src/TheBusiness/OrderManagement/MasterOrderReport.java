
package TheBusiness.OrderManagement;

import TheBusiness.CustomerManagement.CustomersReport;
import TheBusiness.ProductManagement.ProductsReport;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class MasterOrderReport {
    private MasterOrderList masterOrderList;
    private ProductsReport productsReport;
    private CustomersReport customersReport;

    public MasterOrderReport(MasterOrderList masterOrderList) {
        this.masterOrderList = masterOrderList;
        this.productsReport = new ProductsReport();
        this.customersReport = new CustomersReport();
    }

    public void rebuildReports() {
        List<Order> orders = masterOrderList.getOrders();
        productsReport.buildFromOrders(orders);
        customersReport.buildFromOrders(orders);
    }

    public ProductsReport getProductsReport() {
        return productsReport;
    }

    public CustomersReport getCustomersReport() {
        return customersReport;
    }

    public double getTotalRevenue() {
        return masterOrderList.getTotalRevenue();
    }

    public int getTotalOrders() {
        return masterOrderList.size();
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(masterOrderList.getOrders());
    }
}

