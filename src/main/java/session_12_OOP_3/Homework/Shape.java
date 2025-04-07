package session_12_OOP_3.Homework;

public abstract class Shape {
    public abstract double rectangleArea(double length, double width);
    public abstract double squareArea(double length);
    public abstract double circleArea(double radius);
}

class Area extends Shape{
    @Override
    public double rectangleArea(double height, double width) {
        return height * width;
    }

    @Override
    public double squareArea(double length) {
        return length * length;
    }

    @Override
    public double circleArea(double radius) {
        double area = Math.PI * radius * radius;
        return (double) Math.floor(area * 100) / 100;
    }
}

class TestArea{
    public static void main(String[] args) {
        Area area = new Area();
        System.out.println("Area of a rectangle: " + area.rectangleArea(5, 6));
        System.out.println("Area of a square: " + area.squareArea(2));
        System.out.println("Area of a circle: " + area.circleArea(7));
    }
}
