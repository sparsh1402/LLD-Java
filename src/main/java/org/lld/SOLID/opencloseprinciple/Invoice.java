package org.lld.SOLID.opencloseprinciple;

public class Invoice {
    private final double price; //fields immutable if they won't change:
    private final DiscountStrategy discountStrategy;
    public Invoice(double price, DiscountStrategy discountStrategy){
        this.price = price;
        this.discountStrategy = discountStrategy;
    }
    public double getDiscountedPrice(){
        return price - discountStrategy.applyDiscount(price);
    }
}
