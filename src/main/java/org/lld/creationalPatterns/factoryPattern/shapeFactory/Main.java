package org.lld.creationalPatterns.factoryPattern.shapeFactory;
interface Shape {
    void draw();
}
class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}
class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}
class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}
class ShapeFactory{
    public Shape createShape(String shapeType){
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.createShape("CIRcle");
        shape1.draw(); // Output: Drawing Circle
        Shape shape2 = shapeFactory.createShape("SQUARE");
        shape2.draw(); // Output: Drawing Square
        Shape shape3 = shapeFactory.createShape("RECTANGLE");
        shape3.draw(); // Output: Drawing Rectangle
    }
}
