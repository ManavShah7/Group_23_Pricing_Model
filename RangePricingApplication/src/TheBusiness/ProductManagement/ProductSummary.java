/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.ProductManagement;

import TheBusiness.OrderManagement.OrderItem;

/**
 *
 * @author kal bugrara
 */
//this class will extract summary data from the product
public class ProductSummary {

    private Product product;
    private int unitsSold;
    private double totalRevenue;
    private int belowTargetCount;
    private int atTargetCount;
    private int aboveTargetCount;

    public ProductSummary(Product product) {
        this.product = product;
    }

    public void registerSale(OrderItem item) {
        unitsSold += item.getQuantity();
        totalRevenue += item.getItemTotal();

        if (item.isBelowTarget()) {
            belowTargetCount += item.getQuantity();
        } else if (item.isAboveTarget()) {
            aboveTargetCount += item.getQuantity();
        } else {
            atTargetCount += item.getQuantity();
        }
    }

    public Product getProduct() {
        return product;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public int getBelowTargetCount() {
        return belowTargetCount;
    }

    public int getAtTargetCount() {
        return atTargetCount;
    }

    public int getAboveTargetCount() {
        return aboveTargetCount;
    }

    public double getAverageSellingPrice() {
        if (unitsSold == 0) return 0.0;
        return totalRevenue / unitsSold;
    }
}
