package org.lld.benefitsOfComposition;
interface notificationService {
    void sendNotification(String message);
}
class EmailNotificationService implements notificationService{
    @Override
    public void sendNotification(String message){
        System.out.println("Email Notification: " + message);
    }
}

class SMSNotificationService implements notificationService{
    @Override
    public void sendNotification(String message){
        System.out.println("SMS Notification: " + message);
    }
}

class WhatsappNotificationService implements notificationService{
    @Override
    public void sendNotification(String message){
        System.out.println("WhatsApp Notification: " + message);
    }
}

class User {
    private final notificationService notificationService;

    public User( notificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void notifyUser(String message) {
        notificationService.sendNotification(message);
    }
}
public class Main {
    public static void main(String[] args) {
        User user1 = new User(new EmailNotificationService());
        user1.notifyUser("Welcome to our service!");
        User user2 = new User(new SMSNotificationService());
        user2.notifyUser("Your order has been shipped!");
        User user3 = new User(new WhatsappNotificationService());
        user3.notifyUser("Your appointment is confirmed!");
    }
}
