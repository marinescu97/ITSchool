package session_11_OOP_2.Homework.Hierarchical_Inheritance;

public class SpeedBoat extends Boat{
    private double maxSpeed;
    private String engineType;

    public SpeedBoat(double length, double weight, double maxSpeed, String engineType) {
        super(length, weight);
        this.maxSpeed = maxSpeed;
        this.engineType = engineType;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public void turboBoost(){
        System.out.println("Turbo boost activated! Speed increases by 50 km/h.");
        maxSpeed += 50;
    }

    @Override
    public String toString() {
        return String.format("""
                %s
                Max speed: %.1f
                Engine type: %s
                """, super.toString(), maxSpeed, engineType);
    }
}
