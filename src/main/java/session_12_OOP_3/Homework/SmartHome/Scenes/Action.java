package session_12_OOP_3.Homework.SmartHome.Scenes;

import session_12_OOP_3.Homework.SmartHome.Devices.Device;
import session_12_OOP_3.Homework.SmartHome.Types.ControlType;

import java.util.Objects;

public class Action {
    private final Device device;
    private final ControlType control;
    private final Object value;

    public Action(Device device, ControlType control, Object value) {
        this.device = device;
        this.control = control;
        this.value = value;
    }

    public Action(Device device, ControlType control) {
        this.device = device;
        this.control = control;
        this.value = null;
    }

    public void apply(){
        device.handleControl(control, value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Action action = (Action) o;
        return Objects.equals(device, action.device) && control == action.control && Objects.equals(value, action.value);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(device);
        result = 31 * result + Objects.hashCode(control);
        result = 31 * result + Objects.hashCode(value);
        return result;
    }
}
