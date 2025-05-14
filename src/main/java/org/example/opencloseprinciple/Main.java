package org.example.opencloseprinciple;

public class Main {
    public static void main(String[] args) {
        Invoice customerInvoice = new Invoice(100.0, new RegularDiscount());
        System.out.println("Discounted Price: " + customerInvoice.getDiscountedPrice());
        Invoice customerInvoice2 = new Invoice(100.0, new PremiumDiscount());
        System.out.println("Discounted Price: " + customerInvoice2.getDiscountedPrice());
    }
}
