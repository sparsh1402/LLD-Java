package org.lld.singleResponsibility;

class Invoice{
    private String item;
    private double price;
    private int quantity;
    private double total;
    public Invoice(String item, double price, int quantity) {
        this.item = item;
        this.price = price;
        this.quantity = quantity;
        this.total = price * quantity;
    }
    public String getItem() {
        return item;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getTotal() {
        return total;
    }
}

class InvoicePrinter {
    private Invoice invoice;

    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }

    public void printInvoice() {
        System.out.println("Item: " + invoice.getItem());
        System.out.println("Price: " + invoice.getPrice());
        System.out.println("Quantity: " + invoice.getQuantity());
        System.out.println("Total: " + invoice.getTotal());
    }
}

public class Main {
    public static void main(String[] args) {
        Invoice invoice = new Invoice("Laptop", 1000.00, 2);
        InvoicePrinter printer = new InvoicePrinter(invoice);
        printer.printInvoice();
    }
}