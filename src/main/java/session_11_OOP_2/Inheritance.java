package session_11_OOP_2;

public class Inheritance { }

// Single
class A{ }

class B extends A{ }

// Multiple
class Building{ }

class Apartment extends Building{ }

class Room extends Apartment { }

// Hierarchical
class Supercar{ }

class Ferrari extends Supercar{ }

class Lanborghini extends Supercar{ }

// Diamond
class Shape {}

class Square extends Shape{
    public void print(){
        System.out.println("Shape");
    }
}

class Rectangle extends Shape{
    public void print(){
        System.out.println("Rectangle");
    }
}

//class Parallelogram extends Shape, Rectangle{
//    public static void main(String[] args) {
//        Parallelogram p = new Parallelogram();
//        p.print();
//    }
//}
