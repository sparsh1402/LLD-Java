package org.lld.practice.bookMyShow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Strategy Design Pattern
interface PriceStrategy {
    double calculatePrice(String seatType, int quantity);
}

class NormalPriceStrategy implements PriceStrategy {
    @Override
    public double calculatePrice(String seatType, int quantity) {
        if (seatType.equals("Premium")) {
            return 300 * quantity;
        } else if (seatType.equals("Gold")) {
            return 200 * quantity;
        }
        return 100 * quantity;
    }
}

class PremiumPricing implements PriceStrategy{
    @Override
    public double calculatePrice(String seatType, int quantity) {
        if (seatType.equals("Premium")) {
            return 500 * quantity;
        } else if (seatType.equals("Gold")) {
            return 350 * quantity;
        }
        return 200 * quantity;
    }
}


// Factory Design Pattern
interface PaymentMethod {
    void pay(double amount);
}
class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}
class DebitCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Debit Card.");
    }
}
class UpiPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI.");
    }
}

class PaymentFactory {
    public static PaymentMethod getPaymentMethod(String type) {
        if (type.equals("CreditCard")) {
            return new CreditCardPayment();
        } else if (type.equals("DebitCard")) {
            return new DebitCardPayment();
        } else if (type.equals("UPI")) {
            return new UpiPayment();
        }
        throw new IllegalArgumentException("Unknown payment method: " + type);
    }
}

// Singleton Design Pattern

class PaymentGateway {
    private static PaymentGateway instance;
    private PaymentGateway() {}
    public static PaymentGateway getInstance() {
        if (instance == null) {
            instance = new PaymentGateway();
        }
        return instance;
    }
    public void processPayment(PaymentMethod method, double amount) {
        method.pay(amount);
    }
}


// Observer Design Pattern

interface NotificationObserver {
    void update(String message);
}

class EmailObserver implements NotificationObserver {

    @Override
    public void update(String message) {
        System.out.println("[EMAIL] " + message);
    }
}
class SMSObserver implements NotificationObserver {
    @Override
    public void update(String message) {
        System.out.println("[SMS] " + message);
    }
}
class PushObserver implements NotificationObserver {
    @Override
    public void update(String message) {
        System.out.println("[PUSH] " + message);
    }
}

class NotificationService{
    private List<NotificationObserver> observers = new java.util.ArrayList<>();
    public void addObserver(NotificationObserver observer){
        observers.add(observer);
    }
    public void removeObserver(NotificationObserver observer){
        observers.remove(observer);
    }
    public void notifyObservers(String message){
        for(NotificationObserver observer : observers){
            observer.update(message);
        }
    }
}

//adding Seat  locking
enum SeatStatus{
    AVAILABLE,LOCKED,BOOKED
}
class Seat{
    private String seatId;
    private SeatStatus seatStatus;
    public Seat(String seatId){
        this.seatId = seatId;
        this.seatStatus = SeatStatus.AVAILABLE;
    }
    public String getSeatId(){
        return seatId;
    }
    public SeatStatus getSeatStatus(){
        return seatStatus;
    }
    public void lock(){
        if(seatStatus == SeatStatus.AVAILABLE){
            seatStatus = SeatStatus.LOCKED;
        }else{
            throw new IllegalStateException("Seat is not available for locking");
        }
    }
    public void book(){
        if(seatStatus == SeatStatus.LOCKED){
            seatStatus = SeatStatus.BOOKED;
        }else{
            throw new IllegalStateException("Seat is not locked for booking");
        }
    }
    public void release(){
        if(seatStatus == SeatStatus.LOCKED){
            seatStatus = SeatStatus.AVAILABLE;
        }
    }
}

class SeatManager{
    private static SeatManager instance;
    private Map<String,Seat> seats = new HashMap<>();
    private SeatManager(){
        seats.put("G1",new Seat("G1"));
        seats.put("G2",new Seat("G2"));
        seats.put("P1",new Seat("P1"));
        seats.put("P2",new Seat("P2"));
    }
    public static SeatManager getInstance(){
        if(instance == null){
            instance = new SeatManager();
        }
        return instance;
    }

    public synchronized Seat lockSeat(String seatId){
        try {
            Seat seat = seats.get(seatId);
            seat.lock();
            System.out.println("Seat " + seatId + " is LOCKED.");
            return seat;
        }catch (Exception e){
            throw new IllegalStateException("Seat locking failed: " + e.getMessage());
        }


    }
    public synchronized void confirmSeat(String seatId){
        Seat seat = seats.get(seatId);
        seat.book();
        System.out.println("Seat " + seatId + " is BOOKED.");
    }
    public synchronized void releaseSeat(String seatId){
        Seat seat = seats.get(seatId);
        seat.release();
        System.out.println("Seat " + seatId + " is RELEASED.");
    }


}
//Booking Service
class BookingService{
    private PriceStrategy priceStrategy;
    private NotificationService notificationService;
    public BookingService(PriceStrategy priceStrategy, NotificationService notificationService){
        this.priceStrategy = priceStrategy;
        this.notificationService = notificationService;
    }

    public void bookTickets(String seatId , String seatType,int quantity, String paymentType){
        SeatManager seatManager = SeatManager.getInstance();
        try{
            Seat seat = seatManager.lockSeat(seatId);
            double price = priceStrategy.calculatePrice(seatType,quantity);
            System.out.println("Total price: " + price);
            PaymentMethod paymentMethod = PaymentFactory.getPaymentMethod(paymentType);
            PaymentGateway.getInstance().processPayment(paymentMethod,price);
            notificationService.notifyObservers("Booking confirmed for " + quantity + " " + seatType + " seats. Total: " + price);
        }catch (Exception e){
            System.out.println("Booking failed: " + e.getMessage());
            seatManager.releaseSeat(seatType);
        }




    }
}


public class Client {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        notificationService.addObserver(new EmailObserver());
        notificationService.addObserver(new SMSObserver());
        notificationService.addObserver(new PushObserver());

        //Booking with Normal Pricing
        BookingService bookingService = new BookingService(new NormalPriceStrategy(),notificationService);
        String seatId = "G3";
        String seatType = "Gold";
        int quantity = 2;
        String paymentType = "CreditCard";
        bookingService.bookTickets(seatId,seatType,2,paymentType);

    }




}
