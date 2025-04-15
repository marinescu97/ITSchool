package session_12_OOP_3.Homework.SmartHome.Automation;

import session_12_OOP_3.Homework.SmartHome.Devices.Device;
import session_12_OOP_3.Homework.SmartHome.Types.ControlType;
import session_12_OOP_3.Homework.SmartHome.Types.TriggerType;

import java.time.LocalTime;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Trigger {
    private final TriggerType type;
    private Object currentValue;
    private final Set<Rule> rules;
    private Device device;

    public Trigger(TriggerType type) {
        this.type = type;
        this.rules = new TreeSet<>();

        this.currentValue = switch (type){
            case TIME -> LocalTime.now();
            case TEMPERATURE -> 0d;
        };
    }

    public void setCurrentValue(Object currentValue) {
        this.currentValue = currentValue;
        handleRules();
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void addRule(Object targetValue, ControlType controlType, Object value){
        rules.add(new Rule(targetValue, controlType, value));
    }

    public void addRule(Object targetValue, ControlType controlType){
        addRule(targetValue, controlType, null);
    }

    public void deleteRule(Object value){
        Rule rule = findRule(value);

        if (rule != null){
            rules.remove(rule);
        }
    }

    private Rule findRule(Object value){
        for (Rule rule : rules){
            if (rule.getTarget().equals(value)){
                return rule;
            }
        }
        return null;
    }

    private void handleRules(){

        switch (type){
            case TIME -> {
                for (Rule rule : rules){
                    if (((LocalTime) currentValue).isAfter((LocalTime) rule.getTarget())){
                        device.handleControl(rule.getControlType(), rule.getValue());
                        break;
                    }
                }
            }
            case TEMPERATURE -> {
                for (Rule rule : rules){
                    if (((double) currentValue) <= ((double) rule.getTarget())){
                        device.handleControl(rule.getControlType(), rule.getValue());
                        break;
                    }
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Trigger trigger = (Trigger) o;
        return Objects.equals(type, trigger.type);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(type);
    }

    @Override
    public String toString() {
        return type.toString();
    }
}
