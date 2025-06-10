package org.lld.structuralPattern.bridge;

interface Device{
    void turnOff();
    void turnOn();
}

class TV implements Device{
    @Override
    public void turnOff(){
        System.out.println("TV is OFF");
    }
    @Override
    public void turnOn(){
        System.out.println("TV is ON");
    }

}

class Radio implements Device{
    @Override
    public void turnOff(){
        System.out.println("Radio is OFF");
    }
    @Override
    public void turnOn(){
        System.out.println("Radio is ON");
    }
}

abstract class RemoteControl{
    protected Device device;
    public RemoteControl(Device device){
        this.device = device;
    }
    abstract void pressPowerButton();
}

class BasicRemote extends RemoteControl{
    private Boolean isOn = false;
    public BasicRemote(Device device){
        super(device);
    }
    @Override
    void pressPowerButton(){
        if(isOn){
            device.turnOff();
        }else{
            device.turnOn();
        }
        isOn = !isOn;
    }
}

public class RemoteController {
    public static void main(String[] args) {
        BasicRemote remote1 = new BasicRemote(new TV());
        remote1.pressPowerButton();
        remote1.pressPowerButton();
        BasicRemote remote2 = new BasicRemote(new Radio());
        remote2.pressPowerButton();
        remote2.pressPowerButton();
    }
}
