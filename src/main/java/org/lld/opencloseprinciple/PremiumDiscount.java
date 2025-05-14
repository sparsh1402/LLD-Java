package org.lld.opencloseprinciple;

public class PremiumDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double price) {
        return price * 0.3; // 20% discount
    }
}
