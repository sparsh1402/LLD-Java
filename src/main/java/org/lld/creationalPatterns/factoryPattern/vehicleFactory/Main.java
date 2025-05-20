package org.lld.creationalPatterns.factoryPattern.vehicleFactory;
interface Vehicle{
    void start();
}
class Car implements Vehicle{
    @Override
    public void start(){
        System.out.println("Car start");
    }
}

class Bike implements Vehicle{
    @Override
    public void start(){
        System.out.println("Bike start");
    }
}

class VehicleFactory{
    public Vehicle startVehicle(String vehicle){
        if("Car".equalsIgnoreCase(vehicle)){
            return new Car();
        }
        else if("Bike".equalsIgnoreCase(vehicle)){
            return new Bike();
        }
        else{
            throw new IllegalArgumentException("Unknown Vehicle");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();
        Vehicle vehicle1 = factory.startVehicle("Car");
        vehicle1.start();
        Vehicle vehicle2 = factory.startVehicle("Bike");
        vehicle2.start();

    }
}
