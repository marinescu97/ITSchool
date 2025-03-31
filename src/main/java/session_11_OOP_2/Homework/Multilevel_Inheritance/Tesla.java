package session_11_OOP_2.Homework.Multilevel_Inheritance;

public class Tesla extends ElectricCar{
    private String autopilotVersion;

    public Tesla(String make, String model, int year, int batteryCapacity, int range, String autopilotVersion) {
        super(make, model, year, batteryCapacity, range);
        this.autopilotVersion = autopilotVersion;
    }

    public void enableAutopilot(){
        if (isCarStarted()){
            System.out.println("Autopilot version " + autopilotVersion + " is now enabled.");
        } else {
            System.out.println("You need to start the car.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nAutopilot version: " + autopilotVersion + "\n";
    }
}
