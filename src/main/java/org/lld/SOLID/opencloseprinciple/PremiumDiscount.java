package org.lld.SOLID.opencloseprinciple;

public class PremiumDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double price) {
        return price * 0.3; // 20% discount
    }
}
