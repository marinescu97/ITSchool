package session_32_CleanCode;

public class OpenClosedPrincipleAfter {
    public static void main(String[] args) {
        Shape circle = new Circle(12.6);
        System.out.println(circle.calculateArea());

        Shape rectangle = new Rectangle(2, 3);
        System.out.println(rectangle.calculateArea());

        Shape square = new Square(4);
        System.out.println(square.calculateArea());
    }
}

interface Shape{
    double calculateArea();
}

class Circle implements Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(2, radius);
    }
}

class Rectangle implements Shape{
    private double lenght, width;

    public Rectangle(double lenght, double width) {
        this.lenght = lenght;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return lenght * width;
    }
}

class Square implements Shape{
    private double size;

    public Square(double size) {
        this.size = size;
    }

    @Override
    public double calculateArea() {
        return size * size;
    }
}
