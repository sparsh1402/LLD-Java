package org.example.interfaceSegregationPrinciple;
interface Printer {
    void print(String document);
}
interface Scanner{
    void scan(String document);
}

interface Fax{
    void fax(String document);
}
// A multifunction printer that can print, scan, and fax
class MultiFunctionalPrinter implements Printer,Scanner,Fax{
    @Override
    public void print(String document){
        System.out.println("Printing: " + document);
    }
    @Override
    public void scan(String document){
        System.out.println("Scanning: " + document);
    }

    @Override
    public void fax(String document){
        System.out.println("Faxing: " + document);
    }
}

class BasicPrinter implements Printer{
    @Override
    public void print(String document){
        System.out.println("Printing: " + document);
    }
}
public class Main {
    public static void main(String[] args) {
        MultiFunctionalPrinter mfp = new MultiFunctionalPrinter();
        mfp.print("Resume.pdf");
        mfp.scan("Resume.pdf");
        mfp.fax("Resume.pdf");
        BasicPrinter basicPrinter = new BasicPrinter();
        basicPrinter.print("Report.pdf");
    }
}
