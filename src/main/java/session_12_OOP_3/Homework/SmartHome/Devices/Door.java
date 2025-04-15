package session_12_OOP_3.Homework.SmartHome.Devices;

import session_12_OOP_3.Homework.SmartHome.DeviceFunctionalities.Lockable;
import session_12_OOP_3.Homework.SmartHome.DeviceFunctionalities.OpenCloseable;
import session_12_OOP_3.Homework.SmartHome.Types.ControlType;

public class Door extends Device implements OpenCloseable, Lockable {
    private boolean isOpen;
    private boolean isLocked;

    public Door(String name, Double energyConsumption) {
        super(name, energyConsumption);
        this.isOpen = false;
        this.isLocked = false;
    }

    @Override
    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public <T> void handleControl(ControlType control, T value) {
        handleControl(control);
    }

    @Override
    public void lock() {
        if (isOpen) {
            close();
        }

        isLocked = true;
        System.out.println("The " + getName() + " was locked.");
    }

    @Override
    public void unlock() {
        isLocked = false;
        System.out.println("The " + getName() + " was unlocked.");
    }

    @Override
    public void open() {
        if (isLocked) {
            unlock();
        }
        isOpen = true;
        System.out.println("The " + getName() + " was opened.");
    }

    @Override
    public void close() {
        if (isOpen){
            isOpen = false;
            System.out.println("The " + getName() + " was closed.");
        }
    }

    @Override
    public void showDetails() {
        System.out.println(getName() + ": " + (isOpen ? "open" : "closed and " + (isLocked ? "locked" : "unlocked")) + ".");
    }
}
