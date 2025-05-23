package org.lld.SOLID.opencloseprinciple;

public class RegularDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double price) {
        return price * 0.1; // 10% discount
    }
}
