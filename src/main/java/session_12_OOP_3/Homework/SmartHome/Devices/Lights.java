package session_12_OOP_3.Homework.SmartHome.Devices;

import session_12_OOP_3.Homework.SmartHome.DeviceFunctionalities.Switchable;
import session_12_OOP_3.Homework.SmartHome.Types.Colour;
import session_12_OOP_3.Homework.SmartHome.Types.ControlType;

public class Lights extends Device implements Switchable {
    private boolean isOn;
    private int brightness;
    private Colour colour;

    public Lights(String name, Double energyConsumption) {
        super(name, energyConsumption);
        isOn = false;
        brightness = 0;
        colour = Colour.WHITE;
    }

    @Override
    public <T> void handleControl(ControlType control, T value) {
        if (value == null){
            handleControl(control);
        } else {
            switch (control){
                case CHANGE_BRIGHTNESS -> {
                    if (value instanceof Integer integer){
                        changeBrightness(integer);
                    } else if (value instanceof String string) {
                        changeBrightness(Integer.parseInt(string));
                    }
                }
                case CHANGE_COLOUR -> changeColour((Colour) value);
            }
        }
    }

    @Override
    public void turnOn() {
        isOn = true;
        brightness = 70;
        System.out.println("The " + getName() + " turned on.");
    }

    @Override
    public void turnOff() {
        if (isOn){
            isOn = false;
            brightness = 0;
            colour = Colour.WHITE;
            System.out.println("The " + getName() + " turned off.");
        }
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    public void changeBrightness(int brightness){
        if (brightness > 100){
            System.out.println("The maximum brightness level is 100.");
            return;
        }

        if (!isOn){
            turnOn();
        }

        this.brightness = brightness;
        System.out.println("The brightness of " + getName() + " has been changed to " + brightness + "%.");
    }

    public void changeColour(Colour colour){
        if (!isOn){
            turnOn();
        }

        this.colour = colour;
        System.out.println("The colour of " + getName() + " was changed to " + colour + ".");
    }

    @Override
    public void showDetails() {
        System.out.printf("""
                %s:
                State: %s
                Brightness: %d
                Colour: %s
                """, getName(), isOn ? "ON" : "OFF", brightness, isOn ? colour : "-");
    }
}
