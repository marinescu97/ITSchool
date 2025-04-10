package session_13_OOP_4.Homework.Examples;

public class Engine {
    void start(){
        System.out.println("Engine starts");
    }
}

class Car{
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    void start(){
        engine.start();
    }
}

class TestCar{
    public static void main(String[] args) {
        Car car = new Car(new Engine());
        car.start();
    }
}
