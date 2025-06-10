package org.lld.structuralPattern.bridge;
interface PaymentGateway{
    void ProcessPayment(double amount);
}
class RazorGateway implements PaymentGateway{
    @Override
    public void ProcessPayment(double amount){
        System.out.println("Payment of ₹" + amount + " processed through Razorpay.");
    }
}
class StripeGateway implements PaymentGateway{
    @Override
    public  void ProcessPayment(double amount){
        System.out.println("Payment of ₹" + amount + " processed through Stripe");
    }
}
abstract class Payment{
    PaymentGateway paymentGateway;
    public Payment(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }
    abstract void makePayment(double amount);
}

class UPIPayement extends Payment{
    public UPIPayement(PaymentGateway paymentGateway){
        super(paymentGateway);
    }
    @Override
    public void makePayment(double amount){
        paymentGateway.ProcessPayment(amount);
    }
}

class CreditPayement extends Payment{
    public CreditPayement(PaymentGateway paymentGateway){
        super(paymentGateway);
    }
    @Override
    public void makePayment(double amount){
        paymentGateway.ProcessPayment(amount);
    }
}


public class PaymentGatewayBridge {
    public static void main(String[] args) {
        Payment payment1 = new UPIPayement(new RazorGateway());
        payment1.makePayment(10);
        Payment payment2 = new CreditPayement(new StripeGateway());
        payment2.makePayment(20);
        Payment payment3 = new UPIPayement(new StripeGateway());
        payment3.makePayment(30);
        Payment payment4 = new CreditPayement(new RazorGateway());
        payment4.makePayment(40);
    }
}
