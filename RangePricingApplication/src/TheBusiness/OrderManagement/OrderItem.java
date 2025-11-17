/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.OrderManagement;

import TheBusiness.ProductManagement.Product;

/**
 *
 * @author kal bugrara
 */
public class OrderItem {
    private Product product;
    private int quantity;
    private double actualPrice;

    public OrderItem(Product product, int quantity, double actualPrice) {
        this.product = product;
        this.quantity = quantity;
        this.actualPrice = actualPrice;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public double getItemTotal() {
        return quantity * actualPrice;
    }

    public boolean isBelowTarget() {
        return actualPrice < product.getTargetPrice();
    }

    public boolean isAboveTarget() {
        return actualPrice > product.getTargetPrice();
    }

    public boolean isAtTarget() {
        return actualPrice == product.getTargetPrice();
    }
    

}
