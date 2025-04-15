package session_12_OOP_3.Homework.SmartHome.Automation;

import session_12_OOP_3.Homework.SmartHome.Types.ControlType;

import java.time.LocalTime;

public class Rule implements Comparable<Rule> {
    private final Object target;
    private final ControlType controlType;
    private final Object value;

    public Rule(Object target, ControlType controlType, Object value) {
        this.target = target;
        this.controlType = controlType;
        this.value = value;
    }

    public Rule(Object target, ControlType controlType) {
        this(target, controlType, null);
    }

    public Object getTarget() {
        return target;
    }

    public ControlType getControlType() {
        return controlType;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public int compareTo(Rule o) {
        if (this.target instanceof LocalTime){
            return ((LocalTime) o.target).compareTo((LocalTime) this.target);
        } else if (this.target instanceof Double) {
            return ((Double) this.target).compareTo((Double) o.target);
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("""
                Target: %s
                Control: %s
                Value: %s
                """, target, controlType, value);
    }
}
