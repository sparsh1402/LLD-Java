package org.lld.behavioralPattern.commandPattern.ecommerce;

import java.util.Stack;

interface Command {
    public void execute();
    public void unexecute();
}

class AddToCartCommand implements Command {
    public void execute (){
        // Insert row in the cart table
        System.out.println("Item added to cart");
    }
    public void unexecute (){
        // Delete row from the cart table
        System.out.println("Item removed from cart");
    }
}

class PaymentCommand implements Command {
    public void execute (){
        // Insert row in the payments table
        System.out.println("Payment Done");
    }
    public void unexecute (){
        // Delete row from the payments table
        System.out.println("Payment send to client");
    }
}

class CreateOrderCommand implements Command {
    public void execute (){
        // Insert row in the order table
        System.out.println("Order created");
    }
    public void unexecute (){
        // Delete row from the order table
        System.out.println("Order removed");
    }
}

class SendToLogisticsCommand implements Command {
    public void execute (){
        // Insert into logistics table
        System.out.println("Order dispached to logistics");
    }
    public void unexecute (){
        // Delete from the logistics table
        System.out.println("order return from logistics");
    }
}

class DispatchCommand implements Command {
    public void execute (){
        // Insert into Dispatch table
        System.out.println("order dispached to customer");
    }
    public void unexecute (){
        // Delete from the Dispatch table
        System.out.println("order return initiated");
    }
}
class Invoker {
    private Command command;
    public Invoker(Command command){
        this.command = command;
    }
    public void executeCommand(){
        this.command.execute();
    }
    public void unexecuteCommand(){
        this.command.unexecute();
    }
}
public class client {
    public static void main(String[] args) {
        // Stores history of commands so that we can reverse the transactions
        // or go back to the previous state of the applicaion.
        Stack<Command> commandHistory = new Stack<Command>();
        // If add to cart api called
        Command command = new AddToCartCommand();
        Invoker invoker = new Invoker(command);
        invoker.executeCommand();
        commandHistory.push(command);

        // If payment api called
        command = new PaymentCommand();
        invoker = new Invoker(command);
        invoker.executeCommand();
        commandHistory.push(command);

        // If order creation api called
        command = new CreateOrderCommand();
        invoker = new Invoker(command);
        invoker.executeCommand();
        commandHistory.push(command);

        // If send logistics api called
        command = new SendToLogisticsCommand();
        invoker = new Invoker(command);
        invoker.executeCommand();
        commandHistory.push(command);

        // If dispath api called
        command = new DispatchCommand();
        invoker = new Invoker(command);
        invoker.executeCommand();
        commandHistory.push(command);


        command = commandHistory.pop();
        invoker = new Invoker(command);
        invoker.unexecuteCommand();
    }
}
