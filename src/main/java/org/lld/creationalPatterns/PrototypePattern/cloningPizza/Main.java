package org.lld.creationalPatterns.PrototypePattern.cloningPizza;

class Test{ //testing shallow Copy
    private String testing;

    public String getTesting() {
        return testing;
    }

    public void setTesting(String testing) {
        this.testing = testing;
    }
}
class Pizza implements Cloneable{
    private String size;
    private String crust;
    private boolean cheese;
    private boolean pepperoni;

    public Test getTest() {  //testing shallow Copy
        return test;
    }

    public void setTest(Test test) {  //testing shallow Copy
        this.test = test;
    }

    private Test test;  //testing shallow Copy

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public boolean isCheese() {
        return cheese;
    }

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    public boolean isPepperoni() {
        return pepperoni;
    }

    public void setPepperoni(boolean pepperoni) {
        this.pepperoni = pepperoni;
    }

    public Pizza(String size, String crust, boolean cheese, boolean pepperoni,Test test) {
        this.size = size;
        this.crust = crust;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.test = test;  //testing shallow Copy
    }
    public void displayPizza() {
        System.out.println("Size: " + size + ", Crust: " + crust +
                ", Cheese: " + cheese + ", Pepperoni: " + pepperoni + ", Testing:" + this.test.getTesting());
    }

    @Override
    public Pizza clone(){
        try{
            return (Pizza) super.clone(); //shallow copy
        }
        catch (CloneNotSupportedException e){
            throw new RuntimeException("Clone not supported", e);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Test test = new Test();
        test.setTesting("hello");
        Pizza basePizza = new Pizza("Medium", "Thin", true, false,test);
        System.out.println("Original Pizza:");
        basePizza.displayPizza();
        System.out.println("---------------------------------");
        Pizza clonedPizza = basePizza.clone();
        clonedPizza.setCheese(false);
        clonedPizza.getTest().setTesting("Hey"); //testing shallow Copy
        System.out.println("Original Pizza:");
        clonedPizza.displayPizza();

        System.out.println("-----------------------------------");
        System.out.println("Original Pizza");
        basePizza.displayPizza();
    }
}


//Output
/** Original Pizza:
Size: Medium, Crust: Thin, Cheese: true, Pepperoni: false, Testing:hello
---------------------------------
Original Pizza:
Size: Medium, Crust: Thin, Cheese: false, Pepperoni: false, Testing:Hey
-----------------------------------
Original Pizza
Size: Medium, Crust: Thin, Cheese: true, Pepperoni: false, Testing:Hey
* */