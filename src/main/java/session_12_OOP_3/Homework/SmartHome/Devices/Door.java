package session_12_OOP_3.Homework.SmartHome.Devices;

import session_12_OOP_3.Homework.SmartHome.DeviceFunctionalities.Lockable;
import session_12_OOP_3.Homework.SmartHome.DeviceFunctionalities.Notifiable;
import session_12_OOP_3.Homework.SmartHome.DeviceFunctionalities.OpenCloseable;
import session_12_OOP_3.Homework.SmartHome.ExternalIntegrations.WeatherData;
import session_12_OOP_3.Homework.SmartHome.ExternalIntegrations.WeatherService;
import session_12_OOP_3.Homework.SmartHome.Types.ControlType;

import java.time.LocalTime;

public class Door extends Device implements OpenCloseable, Lockable, Notifiable {
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
        alert();
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
    public void alert() {
        if (isOpen && LocalTime.now().getHour() % 2 != 0){
            getHomeOwner().receiveAlert("The " + getName() + " is open at odd hour.");
        }
    }

    @Override
    protected void checkAPIAndAct() {
        WeatherData weather = WeatherService.getCurrentWeather();

         if (weather != null && weather.isRainy()){
             System.out.println("It is raining.");
             close();
         }
    }

    @Override
    public void showDetails() {
        System.out.println(getName() + ": " + (isOpen ? "open" : "closed and " + (isLocked ? "locked" : "unlocked")) + ".");
    }
}
