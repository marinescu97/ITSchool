package session_12_OOP_3.Homework.SmartHome;

import session_12_OOP_3.Homework.SmartHome.DeviceFunctionalities.OpenCloseable;
import session_12_OOP_3.Homework.SmartHome.DeviceFunctionalities.Switchable;
import session_12_OOP_3.Homework.SmartHome.Devices.Device;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Room {
    private String name;
    private boolean isCommon;
    private final Set<Device> devices;
    private LocalDateTime lastOccupiedTime;

    public Room(String name) {
        this.name = name;
        this.isCommon = false;
        this.devices = new HashSet<>();
        this.lastOccupiedTime = LocalDateTime.now();
    }

    public Room(String name, boolean isCommon) {
        this.name = name;
        this.isCommon = isCommon;
        this.devices = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCommon() {
        return isCommon;
    }

    public void setCommon(boolean common) {
        this.isCommon = common;
    }

    public void setLastOccupiedTime(LocalDateTime lastOccupiedTime) {
        this.lastOccupiedTime = lastOccupiedTime;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public void addDevice(Device device){
        if (devices.add(device)){
            System.out.println(device.getName() + " added to " + this.name);
        }
    }

    public void setRoomEmpty() {
        checkEnergySavingAutomations();
    }

    private void checkEnergySavingAutomations() {
        long minutesSinceLastOccupied = java.time.Duration.between(lastOccupiedTime, LocalDateTime.now()).toMinutes();

        if (minutesSinceLastOccupied > 10) {
            System.out.println("Room is empty for more than 10 minutes:");
            for (Device device : devices) {
                if (device instanceof Switchable switchable){
                    if (switchable.isOn()) {
                        System.out.println("Turning off device: " + device.getName());
                        switchable.turnOff();
                    }
                } else if (device instanceof OpenCloseable openCloseable) {
                    if (openCloseable.isOpen()){
                        System.out.println("Closing device: " + device.getName());
                        openCloseable.close();
                    }
                }
            }
        }
        this.lastOccupiedTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return name + devices;
    }
}
