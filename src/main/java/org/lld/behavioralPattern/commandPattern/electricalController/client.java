package org.lld.behavioralPattern.commandPattern.electricalController;
// Step 1: Command interface
interface Command{
     void execute();
}
// Step 2: Receiver classes
class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }
    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

class TV {
    public void turnOn() {
        System.out.println("TV is ON");
    }
    public void turnOff() {
        System.out.println("TV is OFF");
    }
}

// Step 3: Concrete Commands
class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;
    public LightOffCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.turnOff();
    }
}

class TVOnCommand implements Command {
    private TV tv;
    public TVOnCommand(TV tv) {
        this.tv = tv;
    }
    public void execute() {
        tv.turnOn();
    }
}

class TVOffCommand implements Command {
    private TV tv;
    public TVOffCommand(TV tv) {
        this.tv = tv;
    }
    public void execute() {
        tv.turnOff();
    }
}
// Step 4: Invoker
class RemoteControl {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void pressButton() {
        command.execute();
    }
}
public class client {
    public static void main(String[] args) {
        Light light = new Light();
        TV tv = new TV();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command tvOn = new TVOnCommand(tv);
        Command tvOff = new TVOffCommand(tv);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();

        remote.setCommand(tvOn);
        remote.pressButton();

        remote.setCommand(tvOff);
        remote.pressButton();
    }
}
