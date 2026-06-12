public class Abstraction{
    public static void main(String[] args) {
        Shape shape = new Rectangle();

        String name = shape.name;
        System.out.println(name);
        shape.draw();
    }
}

abstract class Shape{
    String name;

    Shape(){
    }

    Shape(String name){
        this.name = name;
    }

    abstract void draw();

    void info(){ System.out.println(" THIS IS SHAPE BASE CLASS.");}
}

class Circle extends Shape{
    Circle(){
        super("CIRCLE");
    }

    @Override
    void draw(){
        System.out.println("DRAWING CIRCLE");
    }
}

class Rectangle extends Shape{
    Rectangle(){
        super("RECTANGLE");
    }

    @Override
    void draw(){
        System.out.println("DRAWING RECTANGLE");
    }
}