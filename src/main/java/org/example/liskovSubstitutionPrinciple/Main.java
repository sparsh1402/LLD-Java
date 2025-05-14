package org.example.liskovSubstitutionPrinciple;
abstract class Bird {
    String name;

    public Bird(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " is eating");
    }
}

// Flying behavior should be separate
interface Flyable {
    void fly();
}

// Only birds that can fly implement this
class Sparrow extends Bird implements Flyable {
    public Sparrow(String name) {
        super(name);
    }

    public void fly() {
        System.out.println(name + " is flying");
    }
}

class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    // No fly() method – LSP is respected
}

public class Main {
    public static void main(String[] args) {
        Bird sparrow = new Sparrow("Sparrow");
        sparrow.eat();
        ((Flyable) sparrow).fly();  // Safe cast since we know it can fly

        Bird penguin = new Penguin("Penguin");
        penguin.eat();
        // ((Flyable) penguin).fly(); // ❌ Compile-time error – can't fly, as expected
    }
}
