package session_16_Hash.Homework;

public enum LightColor {
    RED("Stop", 30),
    YELLOW("Caution", 5),
    GREEN("Go", 45);

    private final String representation;
    private final int duration;

    LightColor(String representation, int duration) {
        this.representation = representation;
        this.duration = duration;
    }

    public String getRepresentation() {
        return representation;
    }

    public int getDuration() {
        return duration;
    }
}

class LightColorTest{
    public static void main(String[] args) {
        for (LightColor color : LightColor.values()){
            System.out.println(color + " -> " + color.getRepresentation() + ", " + color.getDuration());
        }
    }
}
