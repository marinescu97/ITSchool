package session_16_Hash.Homework;

public enum TrafficLight {
    RED(3000),
    GREEN(5000),
    YELLOW(2000);

    private final int duration;

    TrafficLight(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public TrafficLight next() {
        return switch (this) {
            case RED -> GREEN;
            case GREEN -> YELLOW;
            case YELLOW -> RED;
        };
    }
}

class TrafficLightSimulator {
    private TrafficLight currentLight;

    public TrafficLightSimulator() {
        currentLight = TrafficLight.RED;
    }

    public void runSimulation(int cycles) throws InterruptedException {
        for (int i = 0; i < cycles; i++) {
            System.out.println("Light is: " + currentLight);
            Thread.sleep(currentLight.getDuration());
            currentLight = currentLight.next();
        }
    }
}

class TestTrafficLight{
    public static void main(String[] args) throws InterruptedException {
        TrafficLightSimulator simulator = new TrafficLightSimulator();
        simulator.runSimulation(5);
    }
}
