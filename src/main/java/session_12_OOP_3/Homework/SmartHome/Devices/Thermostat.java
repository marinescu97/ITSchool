package session_12_OOP_3.Homework.SmartHome.Devices;

import session_12_OOP_3.Homework.SmartHome.DeviceFunctionalities.Switchable;
import session_12_OOP_3.Homework.SmartHome.ExternalIntegrations.WeatherData;
import session_12_OOP_3.Homework.SmartHome.ExternalIntegrations.WeatherService;
import session_12_OOP_3.Homework.SmartHome.Types.ControlType;

public class Thermostat extends Device implements Switchable {
    private boolean isOn;
    private double temperature;

    public Thermostat(String name, Double energyConsumption) {
        super(name, energyConsumption);
        this.isOn = false;
        this.temperature = 0;
    }

    @Override
    public <T> void handleControl(ControlType control, T value) {
        if (value == null){
            handleControl(control);
        } else if (control.equals(ControlType.CHANGE_TEMPERATURE)){
            changeTemperature((Double) value);
        }
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

    public void changeTemperature(double temperature){
        if (temperature <= 0 || temperature >= 30){
            System.out.println("Invalid tempretature for " + getName() + ".");
            return;
        }

        if (!isOn){
            turnOn();
        }

        this.temperature = (double) Math.round(temperature * 100) / 100;
        System.out.println("The temperature of " + getName() + " was changed to " + this.temperature + ".");
    }

    @Override
    protected void checkAPIAndAct() {
        WeatherData weather = WeatherService.getCurrentWeather();

        if (weather != null) {
            System.out.println("Temperature from local weather API: " + weather.temperature());
            int targetTemperature = 20;
            if (weather.temperature() > 28){
                targetTemperature = 18;
            } else if (weather.temperature() < 18) {
                targetTemperature = 23;
            }
            changeTemperature(targetTemperature);
        }
    }

    @Override
    public void showDetails() {
        System.out.printf("""
                %s:
                Status: %s
                Temperature: %s
                """, getName(), isOn ? "ON" : "OFF", temperature);
    }
}
