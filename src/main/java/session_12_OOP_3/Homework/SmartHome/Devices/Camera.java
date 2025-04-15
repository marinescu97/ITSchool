package session_12_OOP_3.Homework.SmartHome.Devices;

import session_12_OOP_3.Homework.SmartHome.DeviceFunctionalities.Switchable;
import session_12_OOP_3.Homework.SmartHome.Types.ControlType;

public class Camera extends Device implements Switchable {
    private boolean isOn;
    private boolean isRecording;
    private boolean movement;

    public Camera(String name, Double energyConsumption) {
        super(name, energyConsumption);
        this.isOn = false;
        this.isRecording = false;
        this.movement = false;
    }

    public void setMovement(boolean movement) {
        this.movement = movement;

        handleRecording();
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

    public void record(){
        if (!isRecording){
            turnOn();
            isRecording = true;
            System.out.println("The " + getName() + " is recording.");
        }
    }

    public void stopRecording(){
        if (isRecording){
            isRecording = false;
            System.out.println("The " + getName() + " stopped recording.");
        }
    }

    private void handleRecording(){
        if (movement){
            record();
            super.getEnergyManager().startUsage();
        } else {
            stopRecording();
            super.getEnergyManager().stopUsage();
        }
    }

    @Override
    public void showDetails() {
        System.out.printf("""
                %s:
                Status: %s
                Recording: %s
                """, getName(), (isOn ? "ON" : "OFF"), (isRecording ? "Yes" : "No"));
    }
}
