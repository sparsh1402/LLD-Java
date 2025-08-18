package org.lld.behavioralPattern.strategyPattern.modesOfPayment;
//step 1 strategy
interface PaymentMethod{
    double calculateProcessingFee(double amount);
}
//step 2 concrete strategy

class CreditCard implements PaymentMethod{



    @Override
    public double calculateProcessingFee(double amount) {
        return amount * 0.02;
    }

}

class DebitCardPayment implements PaymentMethod {
    @Override
    public double calculateProcessingFee(double amount) {
        return amount * 0.01;
    }
}

class NetBankingPayment implements PaymentMethod {
    @Override
    public double calculateProcessingFee(double amount) {
        return amount * 0.005;
    }
}

class PaymentGateway {
    private PaymentMethod paymentMethod;
    public PaymentGateway(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double processPayment(double amount) {
        return amount + paymentMethod.calculateProcessingFee(amount);
    }
}

public class client {
    public static void main(String[] args) {
        double amount = 10.0;
        PaymentGateway paymentGateway = new PaymentGateway(new CreditCard());
        System.out.println("Processed amount through credit card: " + paymentGateway.processPayment(amount));

        PaymentGateway paymentGateway1 = new PaymentGateway(new DebitCardPayment());
        System.out.println("Processed amount through debit card: " + paymentGateway1.processPayment(amount));

        PaymentGateway paymentGateway2 = new PaymentGateway(new NetBankingPayment());
        System.out.println("Processed amount through net banking: " + paymentGateway2.processPayment(amount));



    }
}
