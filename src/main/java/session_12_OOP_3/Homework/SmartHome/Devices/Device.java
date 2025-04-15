package session_12_OOP_3.Homework.SmartHome.Devices;

import session_12_OOP_3.Homework.SmartHome.Automation.Trigger;
import session_12_OOP_3.Homework.SmartHome.DeviceFunctionalities.Lockable;
import session_12_OOP_3.Homework.SmartHome.DeviceFunctionalities.OpenCloseable;
import session_12_OOP_3.Homework.SmartHome.DeviceFunctionalities.Switchable;
import session_12_OOP_3.Homework.SmartHome.EnergyManager;
import session_12_OOP_3.Homework.SmartHome.Types.ControlType;

import java.util.HashSet;
import java.util.Set;

public abstract class Device {
    private final String name;
    private final Set<Trigger> triggers;
    private final EnergyManager energyManager;

    public Device(String name, Double energyConsumption) {
        this.name = name;
        this.triggers = new HashSet<>();
        this.energyManager = new EnergyManager(name, energyConsumption);
    }

    public String getName() {
        return name;
    }

    public EnergyManager getEnergyManager() {
        return energyManager;
    }

    public abstract void showDetails();

    public void handleControl(ControlType controlType){
        if (this instanceof OpenCloseable openCloseable){
            switch (controlType){
                case OPEN -> {
                    openCloseable.open();
                    energyManager.addEnergyConsumption();
                }
                case CLOSE -> {
                    openCloseable.close();
                    energyManager.addEnergyConsumption();
                }
            }
        }

        if (this instanceof Switchable switchable){
            switch (controlType){
                case TURN_ON -> {
                    switchable.turnOn();
                    energyManager.startUsage();
                }
                case TURN_OFF -> {
                    switchable.turnOff();
                    energyManager.stopUsage();
                }
                case RECORD -> {
                    ((Camera) this).record();
                    energyManager.startUsage();
                }
                case STOP_RECORDING -> {
                    ((Camera) this).stopRecording();
                    energyManager.stopUsage();
                }
            }
        }

        if (this instanceof Lockable lockable){
            switch (controlType){
                case LOCK -> {
                    lockable.lock();
                    energyManager.addEnergyConsumption();
                }
                case UNLOCK -> {
                    lockable.unlock();
                    energyManager.addEnergyConsumption();
                }
            }
        }
    }

    public abstract  <T> void handleControl(ControlType control, T value);

    public void addTrigger(Trigger trigger){
        triggers.add(trigger);
        trigger.setDevice(this);
    }

    public void addTriggerRule(Trigger trigger, Object targetValue, ControlType controlType, Object value){
        Trigger currentTrigger = findTrigger(trigger);

        if (currentTrigger != null){
            currentTrigger.addRule(targetValue, controlType, value);
        } else {
            addTrigger(trigger);
            addTriggerRule(trigger, targetValue, controlType, value);
        }
    }

    public void deleteTriggerRule(Trigger trigger, Object value){
        Trigger currentTrigger = findTrigger(trigger);
        if (currentTrigger != null){
            trigger.deleteRule(value);
        }
    }

    private Trigger findTrigger(Trigger trigger){
        for (Trigger currentTrigger : triggers){
            if (currentTrigger.equals(trigger)){
                return trigger;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
