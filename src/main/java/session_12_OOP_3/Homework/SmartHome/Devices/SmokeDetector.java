package session_12_OOP_3.Homework.SmartHome.Devices;

import session_12_OOP_3.Homework.SmartHome.DeviceFunctionalities.Switchable;
import session_12_OOP_3.Homework.SmartHome.Types.ControlType;

public class SmokeDetector extends Device implements Switchable {
    private boolean isOn;

    public SmokeDetector(String name, Double energyConsumption) {
        super(name, energyConsumption);
        this.isOn = false;
    }

    @Override
    public <T> void handleControl(ControlType control, T value) {
        handleControl(control);
    }

    @Override
    public void turnOn() {
        if (!isOn){
            isOn = true;
            System.out.println("The " + getName() + " turned on.");
        }
    }

    @Override
    public void turnOff() {
        if (isOn){
            isOn = false;
            System.out.println("The " + getName() + " turned off.");
        }
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void showDetails() {
        System.out.printf("""
                %s:
                Smoke detected: %s
                """, getName(), (isOn ? "YES" : "NO"));
    }
}
