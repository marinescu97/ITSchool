package session_12_OOP_3.Homework.SmartHome.Types;

public enum ControlType {
    TURN_ON,
    TURN_OFF,
    OPEN,
    CLOSE,
    LOCK,
    UNLOCK,
    CHANGE_BRIGHTNESS,
    CHANGE_COLOUR,
    SWITCH_CHANNEL,
    CHANGE_VOLUME,
    RECORD,
    STOP_RECORDING,
    CHANGE_MODE,
    CHANGE_TEMPERATURE;

    @Override
    public String toString() {
        if (name().contains("_")){
            String[] split = name().split("_");
            return String.join(" ", split).toLowerCase();
        }

        return name().toLowerCase();
    }
}
