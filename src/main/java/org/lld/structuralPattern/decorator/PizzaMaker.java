package org.lld.structuralPattern.decorator;
interface Pizza {
    String getDescription();
    double getCost();
}

class MargeritaPizza implements Pizza{
    @Override
    public String getDescription(){
        return "Margerita Pizza";
    }
    @Override
    public double getCost(){
        return 100.0;
    }
}
abstract class PizzaDecorator implements Pizza{
    Pizza pizza;
    public PizzaDecorator(Pizza pizza){
        this.pizza = pizza;
    }
}

class CheeseDecorator extends PizzaDecorator{
    public CheeseDecorator(Pizza pizza){
        super(pizza);
    }
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }
    public double getCost(){
        return pizza.getCost() + 40;
    }
}
class OliveDecorator extends PizzaDecorator{
    public OliveDecorator(Pizza pizza){
        super(pizza);
    }
    public String getDescription(){
        return pizza.getDescription() + ", Olives";
    }
    public double getCost(){
        return pizza.getCost() + 40;
    }
}

public class PizzaMaker {
    public static void main(String[] args) {
        Pizza pizza = new MargeritaPizza();
        System.out.println(pizza.getDescription() + "-> $" + pizza.getCost());
        pizza = new CheeseDecorator(pizza);
        System.out.println(pizza.getDescription() + "-> $" + pizza.getCost());
        pizza = new OliveDecorator(pizza);
        System.out.println(pizza.getDescription() + "-> $" + pizza.getCost());
    }

}
