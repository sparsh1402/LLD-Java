package org.lld.creationalPatterns.abstractFactoryPattern.vehicleFactory;
interface Car{
    void drive();
}
interface Bike{
    void ride();
}
class ElectricCar implements Car{
    @Override
    public void drive(){
        System.out.println("Driving electric car");
    }
}
class ElectricBike implements Bike{
    @Override
    public void ride() {
        System.out.println("Riding electric bike");
    }
}
class PetrolCar implements Car{
    @Override
    public void drive() {
        System.out.println("Driving Petrol car");
    }
}
class PetrolBike implements Bike{
    @Override
    public void ride() {
        System.out.println("Riding petrol bike");
    }
}

interface VehicleFactory{
    Car createCar();
    Bike createBike();
}

class ElectricVehicleFactory implements VehicleFactory{
    @Override
    public Car createCar(){
        return new ElectricCar();
    }
    @Override
    public Bike createBike(){
        return new ElectricBike();
    }
}

class PetrolVehicleFactory implements VehicleFactory{
    @Override
    public Car createCar(){
        return new PetrolCar();
    }
    @Override
    public Bike createBike(){
        return new PetrolBike();
    }
}

public class Main {
    public static void main(String[] args) {
        VehicleFactory factory1 = new ElectricVehicleFactory();
        Car car1 = factory1.createCar();
        car1.drive();
        Bike bike1 = factory1.createBike();
        bike1.ride();
        VehicleFactory factory2 = new PetrolVehicleFactory();
        Car car2 = factory2.createCar();
        car2.drive();
        Bike bike2 = factory2.createBike();
        bike2.ride();

    }
}
