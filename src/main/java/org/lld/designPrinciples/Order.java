package org.lld.designPrinciples;

public final class Order {
    private final String orderId;
    private final Product product;
    private final int quantity;

    public Order(String orderId, Product product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }
    public String getOrderId() {
        return orderId;
    }
    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
}
