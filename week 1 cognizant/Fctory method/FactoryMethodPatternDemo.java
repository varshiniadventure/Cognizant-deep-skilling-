interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle.");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a Rectangle.");
    }
}

abstract class ShapeFactory {
    public abstract Shape createShape();
}

class CircleFactory extends ShapeFactory {
    public Shape createShape() {
        return new Circle();
    }
}

class RectangleFactory extends ShapeFactory {
    public Shape createShape() {
        return new Rectangle();
    }
}

public class FactoryMethodPatternDemo {
    public static void main(String[] args) {
        ShapeFactory factory1 = new CircleFactory();
        Shape shape1 = factory1.createShape();
        shape1.draw();

        ShapeFactory factory2 = new RectangleFactory();
        Shape shape2 = factory2.createShape();
        shape2.draw();
    }
}
