package org.example.dependencyInversionPrinciple;

interface Keyboard {
    void type();
}

class MechanicalKeyboard implements Keyboard {
    @Override
    public void type() {
        System.out.println("Typing with Mechanical Keyboard");
    }
}

class MembraneKeyboard implements Keyboard {
    @Override
    public void type() {
        System.out.println("Typing with Membrane Keyboard");
    }
}

class Computer {
    private Keyboard keyboard;

    public Computer(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public void type() {
        keyboard.type();
    }
}
public class Main {
    public static void main(String[] args) {
            Computer pc1 = new Computer(new MechanicalKeyboard());
            pc1.type();  // Output: Typing with Mechanical Keyboard

            Computer pc2 = new Computer(new MembraneKeyboard());
            pc2.type();  // Output: Typing with Membrane Keyboard
    }
}
