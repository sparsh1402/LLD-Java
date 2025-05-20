package org.lld.SOLID.liskovSubstitutionPrinciple;
abstract class Account{
    private double balance;
    public void deposit(double amount){
        System.out.println("Depositing $" + amount);
    }
}
interface widrawal{
    void withdraw(double amount);
}
class SavingAccount extends Account implements widrawal{
    public void withdraw(double amount){
        System.out.println("Withdrawing $" + amount);
    }
}
class FixedDepositAccount extends Account{

}
public class Main1 {
    public static void main(String[] args) {
        Account savingAccount = new SavingAccount();
        savingAccount.deposit(1000);
        ((widrawal) savingAccount).withdraw(500); // Safe cast since we know it can withdraw
        Account fixedDepositAccount = new FixedDepositAccount();
        fixedDepositAccount.deposit(2000);

    }
}
