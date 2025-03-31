package session_11_OOP_2.Homework.Multilevel_Inheritance;

public class ElectricCar extends Car{
    private int batteryCapacity;
    private int range;

    public ElectricCar(String make, String model, int year, int batteryCapacity, int range) {
        super(make, model, year);
        this.batteryCapacity = batteryCapacity;
        this.range = range;
    }

    public void charge(){
        if (isCarStarted()){
            System.out.println("The car must be stopped.");
        } else {
            System.out.println("The electric car is charging ...");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nBattery capacity: " + batteryCapacity + "\nRange: " + range;
    }
}
