package session_12_OOP_3.Homework.SmartHome.Scenes;

import session_12_OOP_3.Homework.SmartHome.Devices.Device;
import session_12_OOP_3.Homework.SmartHome.Types.ControlType;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Scene {
    private String name;
    private final Set<Action> actions;

    public Scene(String name) {
        this.name = name;
        this.actions = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAction(Device device, ControlType control){
        actions.add(new Action(device, control));
    }

    public void addAction(Device device, ControlType control, Object value){
        actions.add(new Action(device, control, value));
    }

    public void applyActions(){
        System.out.println("Activating Scene: " + name);

        for (Action action : actions){
            action.apply();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Scene scene = (Scene) o;
        return Objects.equals(getName(), scene.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }
}
