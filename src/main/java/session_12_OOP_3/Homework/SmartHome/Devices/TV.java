package session_12_OOP_3.Homework.SmartHome.Devices;

import session_12_OOP_3.Homework.SmartHome.DeviceFunctionalities.Switchable;
import session_12_OOP_3.Homework.SmartHome.Types.ControlType;

public class TV extends Device implements Switchable {
    private boolean isOn;
    private int channel;
    private int volume;

    public TV(String name, Double energyConsumption) {
        super(name, energyConsumption);
        isOn = false;
        channel = 1;
        volume = 10;
    }

    @Override
    public <T> void handleControl(ControlType control, T value) {
        if (value == null){
            handleControl(control);
        } else {
            switch (control){
                case SWITCH_CHANNEL -> changeChannel((Integer) value);
                case CHANGE_VOLUME -> changeVolume((Integer) value);
            }
        }
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("The " + getName() + " turned on.");
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

    public void changeChannel(int channel){
        if (channel < 0 || channel > 100){
            System.out.println("Please insert a number between 1 and 100.");
            return;
        }

        if (!isOn){
            turnOn();
        }

        this.channel = channel;
        System.out.println("The " + getName() + " switched to channel " + channel);
    }

    public void changeVolume(int volume){
        if (volume < 0 || volume > 100){
            System.out.println("Please insert a number between 1 and 100.");
            return;
        }

        if (!isOn){
            turnOn();
        }

        this.volume = volume;
        System.out.println(getName() + "'s volume changed to  " + volume);
    }

    @Override
    public void showDetails() {
        System.out.printf("""
                %s:
                State: %s
                Channel: %d
                Volume: %d
                """, getName(), (isOn ? "ON" : "OFF"), (isOn ? channel : 0), (isOn ? volume : 0));
    }
}
