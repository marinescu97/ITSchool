package session_13_OOP_4;

public class Calculator {
    public int add(int a, int b){
        return a + b;
    }

    public int add(int a, int b, int c){
        return a + b + c;
    }

    public double add(double a, double b){
        return a + b;
    }
}

class Geometry{
    public double area(double base, double height){
        return base * height * 0.5;
    }

    public double area(double radius){
        return Math.PI * radius * radius;
    }
}

class Main{
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println(calculator.add(3, 5));
        System.out.println(calculator.add(3, 5, 2));
        System.out.println(calculator.add(2.5, 2.8));

        Geometry geometry = new Geometry();
        System.out.println(geometry.area(2.5, 3));
        System.out.println(geometry.area(4));
    }
}
