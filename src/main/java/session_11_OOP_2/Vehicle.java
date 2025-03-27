package session_11_OOP_2;

public class Vehicle {
    private String brand;
    private String model;
    private int year;

    public Vehicle(String brand, String model, int year){
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public String display() {
        return "Vehicle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}

class Car extends Vehicle{
    private int nrDoors;

    public Car(String brand, String model, int year, int nrDoors) {
        super(brand, model, year);
        this.nrDoors = nrDoors;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public void setNrDoors(int nrDoors) {
        this.nrDoors = nrDoors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "nrDoors=" + nrDoors +
                '}';
    }
}

class ElectricCar extends Car{
    private int improvedBattery;

    public ElectricCar(String brand, String model, int year, int nrDoors, int improvedBattery) {
        super(brand, model, year, nrDoors);
        this.improvedBattery = improvedBattery;
    }

    public int getImprovedBattery() {
        return improvedBattery;
    }

    public void setImprovedBattery(int improvedBattery) {
        this.improvedBattery = improvedBattery;
    }

    @Override
    public String toString() {
        return "ElectricCar{" +
                "improvedBattery=" + improvedBattery +
                '}';
    }
}

class Truck extends Vehicle{
    private int improvedCapacitate;

    public Truck(String brand, String model, int year, int improvedCapacitate) {
        super(brand, model, year);
        this.improvedCapacitate = improvedCapacitate;
    }

    public int getImprovedCapacitate() {
        return improvedCapacitate;
    }

    public void setImprovedCapacitate(int improvedCapacitate) {
        this.improvedCapacitate = improvedCapacitate;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "improvedCapacitate=" + improvedCapacitate +
                '}';
    }
}

class MainVehicle{
    public static void main(String[] args) {
        ElectricCar ec = new ElectricCar("Tesla", "3", 2021, 4, 40000);
        System.out.println(ec.getImprovedBattery());
        System.out.println(ec.display());
        System.out.println(ec.getBrand());
        System.out.println(ec.getModel());
        System.out.println(ec.getNrDoors());
        System.out.println(ec.getYear());
    }
}
