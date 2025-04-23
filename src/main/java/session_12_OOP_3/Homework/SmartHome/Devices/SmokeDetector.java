package session_12_OOP_3.Homework.SmartHome.Devices;

import session_12_OOP_3.Homework.SmartHome.DeviceFunctionalities.Notifiable;
import session_12_OOP_3.Homework.SmartHome.DeviceFunctionalities.Switchable;
import session_12_OOP_3.Homework.SmartHome.Room;
import session_12_OOP_3.Homework.SmartHome.Types.ControlType;
import session_12_OOP_3.Homework.SmartHome.UserProfile.Owner;
import session_12_OOP_3.Homework.SmartHome.UserProfile.User;

public class SmokeDetector extends Device implements Switchable, Notifiable {
    private boolean isOn;
    private boolean isSmoke;

    public SmokeDetector(String name, Double energyConsumption) {
        super(name, energyConsumption);
        this.isOn = false;
        this.isSmoke = false;
    }

    public void setSmoke(boolean smoke) {
        isSmoke = smoke;
        handleDetector();
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

    private void handleDetector(){
        if (isSmoke){
            turnOn();
            alert();
            turnOnAllLights();
        } else {
            turnOff();
        }
    }

    @Override
    public void alert(){
        String message = "Smoke detected! Evacuate immediately!";
        Owner owner = getHomeOwner();
        owner.receiveAlert(message);

        for (User user : owner.getFriends()){
            user.receiveAlert(message);
        }
    }

    private void turnOnAllLights(){
        for (Room room : getHomeOwner().getRooms()){
            for (Device device : room.getDevices()){
                if (device instanceof Lights){
                    device.handleControl(ControlType.TURN_ON);
                }
            }
        }
    }

    @Override
    public void showDetails() {
        System.out.printf("""
                %s:
                Smoke detected: %s
                """, getName(), (isOn ? "YES" : "NO"));
    }
}
