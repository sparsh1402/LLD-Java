package org.lld.structuralPattern.decorator;
interface Coffee {
    public String getDescription();
    public double getCost();
}

class simpleCoffee implements Coffee {
    @Override
    public String getDescription(){
        return "Simple coffee";
    }
    @Override
    public double getCost(){
        return 1.5;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;
    public CoffeeDecorator(Coffee coffee){
        this.decoratedCoffee = coffee;
    }
    @Override
    public String getDescription(){
        return decoratedCoffee.getDescription();
    }
    @Override
    public double getCost(){
        return decoratedCoffee.getCost();
    }
}

class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee coffee){
        super(coffee);
    }
    public String getDescription(){
        return super.getDescription() + " , Milk";
    }
    public double getCost(){
        return super.getCost() + 1.5;
    }
}

class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee coffee){
        super(coffee);
    }
    public String getDescription(){
        return super.getDescription() + " , Sugar";
    }
    public double getCost(){
        return super.getCost() + 1.5;
    }
}

public class coffeeMaker {
    public static void main(String[] args) {
        Coffee coffee = new simpleCoffee();
        System.out.println(coffee.getDescription() + " -> $" + coffee.getCost());
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + "-> $"+ coffee.getCost());
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + "-> $" + coffee.getCost());
    }
}
