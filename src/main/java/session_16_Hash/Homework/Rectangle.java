package session_16_Hash.Homework;

import java.util.Objects;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(width, rectangle.width) == 0 && Double.compare(height, rectangle.height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}

class TestRectangle{
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(23.5, 20d);
        Rectangle r2 = new Rectangle(23.5, 20d);
        Rectangle r3 = new Rectangle(21d, 20d);

        System.out.println("r1 equals r2? " + r1.equals(r2));
        System.out.println("r1 equals r3? " + r1.equals(r3));
        System.out.println("r1 hashcode: " + r1.hashCode());
        System.out.println("r2 hashcode: " + r2.hashCode());
        System.out.println("r3 hashcode: " + r3.hashCode());
    }
}
