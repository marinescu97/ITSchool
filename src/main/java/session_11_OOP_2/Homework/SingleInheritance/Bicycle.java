package session_11_OOP_2.Homework.SingleInheritance;

public class Bicycle {
    private int speed;
    private int gear;

    public Bicycle() {
        this.speed = 0;
        this.gear = 1;
    }

    public int getSpeed() {
        return speed;
    }

    private void changeGear(){
        if (speed >= 0 && speed <= 10) {
            this.gear = 1;
        } else if (speed > 10 && speed <= 20) {
            this.gear = 2;
        } else if (speed > 20 && speed <= 30) {
            this.gear = 3;
        } else if (speed > 30 && speed <= 40) {
            this.gear = 4;
        } else if (speed > 40 && speed <= 50) {
            this.gear = 5;
        } else{
            this.gear = 6;
        }
        System.out.println("Gear changed to: " + this.gear);
    }

    public void speedUp(int speed){
        this.speed += speed;
        System.out.println("Speed increased to: " + this.speed + " km/h");
        changeGear();
    }

    public void applyBrake(int decrement){
        if (this.speed - decrement >= 0) {
            this.speed -= decrement;
            System.out.println("Speed decreased to: " + this.speed + " km/h");
        } else {
            this.speed = 0;
            System.out.println("Bicycle stopped. Speed is now: " + this.speed + " km/h");
        }
        changeGear();
    }

    public void display(){
        System.out.println("Current speed: " + this.speed + " km/h");
        System.out.println("Current gear: " + this.gear);
    }
}
