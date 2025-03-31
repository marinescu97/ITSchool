package session_11_OOP_2.Homework.SingleInheritance;

public class MountainBike extends Bicycle{
    private String tireType;
    private String suspension;

    public MountainBike(String tireType, String suspension) {
        super();
        this.tireType = tireType;
        this.suspension = suspension;
    }

    @Override
    public void speedUp(int speed) {
        super.speedUp(speed);
        adjustSuspension();
    }

    @Override
    public void applyBrake(int decrement) {
        super.applyBrake(decrement);
        adjustSuspension();
    }

    public void adjustSuspension(){
        if (getSpeed() <= 10) {
            this.suspension = "Soft";
        } else if (getSpeed() <= 20) {
            this.suspension = "Medium";
        } else {
            this.suspension = "Firm";
        }
        System.out.println("Suspension adjusted to: " + this.suspension);
    }
}
