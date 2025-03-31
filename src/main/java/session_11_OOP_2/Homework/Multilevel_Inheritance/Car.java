package session_11_OOP_2.Homework.Multilevel_Inheritance;

public class Car {
    private String make;
    private String model;
    private int year;
    private boolean carStarted;
    private int speed;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        carStarted = false;
        speed = 0;
    }

    public boolean isCarStarted() {
        return carStarted;
    }

    public void start(){
        if (!carStarted){
            System.out.println("The car started.");
            carStarted = true;
        } else {
            System.out.println("The car is already started");
        }
    }

    public void stop(){
        if (speed == 0){
            System.out.println("The car stopped");
            carStarted = false;
        } else {
            System.out.println("You need to apply the brake.");
        }
    }

    public void accelerate(int newSpeed){
        if (carStarted){
            speed += newSpeed;
            System.out.println("The car acceletared to " + speed + " km/h");
        } else {
            System.out.println("You need to start the car.");
        }
    }

    public void applyBrake(int decrement){
        if (speed - decrement >= 0){
            speed -= decrement;
            System.out.println("The car deceletated to " + speed + " km/h");
        } else {
            speed = 0;
            System.out.println("The speed is " + speed + " km/h");
        }
    }

    @Override
    public String toString() {
         return this.getClass().getSimpleName() + "\nMake: " + make + "\nModel: " + model + "\nYear: " + year;
    }
}
