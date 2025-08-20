package org.lld.behavioralPattern.templatePattern.teaCoffee;

abstract class HotDrink{
    public final void prepareDrink(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    private void boilWater(){
        System.out.println("Boiling water");
    }
    private void pourInCup(){
        System.out.println("Pour in cup");
    }

    protected abstract void brew();
    protected  abstract  void addCondiments();
}

class PrepareTea extends HotDrink{
    @Override
    protected void brew(){
        System.out.println("Steeping tea bag");
    }
    @Override
    protected void addCondiments(){
        System.out.println("Adding ginger");
    }
}

class PrepareCoffee extends HotDrink{
    @Override
    protected void brew(){
        System.out.println("Dripping coffee through filter");
    }
    @Override
    protected void addCondiments(){
        System.out.println("Adding sugar and milk");
    }
}



public class Client {
    public static void main(String[] args) {
        System.out.println("One Hot coffee please!!!!!!!!!!!!");
        HotDrink coffee = new PrepareCoffee();
        coffee.prepareDrink();
        System.out.println("One Tea please!!!!!!!!!!!!");
        HotDrink tea = new PrepareTea();
        tea.prepareDrink();
    }
}
