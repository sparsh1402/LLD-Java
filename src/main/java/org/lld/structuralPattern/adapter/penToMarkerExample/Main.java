package org.lld.structuralPattern.adapter.penToMarkerExample;
//target
interface Marker{
    void mark(String text);
}

//Adaptee class
class Pen{
    public void write(String text){
        System.out.println("writing with pen: " + text);
    }
}

//Adapter class
class PenAdapter implements Marker{
    private Pen pen;
    public PenAdapter(Pen pen){
        this.pen = pen;
    }
    @Override
    public void mark(String text){
        pen.write(text);
    }
}

public class Main {
    public static void main(String[] args) {
        Marker marker = new PenAdapter(new Pen());
        marker.mark("Hey Adapter Pattern");
    }
}
