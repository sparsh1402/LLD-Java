package org.lld.structuralPattern.facade;
class KYCService {
    public void verifyIdentity(String name) {
        System.out.println("KYC verification completed for " + name);
    }
}

class AccountService {
    public void openAccount(String name) {
        System.out.println("Bank account opened for " + name);
    }
}

class DebitCardService {
    public void issueCard(String name) {
        System.out.println("Debit card issued for " + name);
    }
}

class NotificationService {
    public void sendWelcomeMessage(String name) {
        System.out.println("Welcome message sent to " + name);
    }
}
class BankFacade {
    private KYCService kycService;
    private AccountService accountService;
    private DebitCardService debitCardService;
    private NotificationService notificationService;

    public BankFacade() {
        this.kycService = new KYCService();
        this.accountService = new AccountService();
        this.debitCardService = new DebitCardService();
        this.notificationService = new NotificationService();
    }

    public void openNewAccount(String name) {
        System.out.println("Starting account opening process...");
        kycService.verifyIdentity(name);
        accountService.openAccount(name);
        debitCardService.issueCard(name);
        notificationService.sendWelcomeMessage(name);
        System.out.println("Account opening process completed.");
    }
}

public class BankingAccountFacadeMain {
    public static void main(String[] args) {
        BankFacade bankFacade = new BankFacade();
        bankFacade.openNewAccount("Sparsh Agarwal");
    }
}
