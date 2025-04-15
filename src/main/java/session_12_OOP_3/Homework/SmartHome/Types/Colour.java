package session_12_OOP_3.Homework.SmartHome.Types;

public enum Colour {
    YELLOW, WHITE, GREEN, BLUE, RED, PURPLE, ORANGE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
