package session_11_OOP_2.Homework.Multilevel_Inheritance;

public class TestCar {
    public static void main(String[] args) {
        Tesla tesla = new Tesla("Tesla", "S", 2024, 100, 370, "Full Self-Driving V9");

        tesla.start();
        tesla.accelerate(150);
        tesla.applyBrake(150);
        tesla.charge();
        tesla.stop();
        tesla.charge();
        tesla.start();
        tesla.enableAutopilot();

        System.out.println("\nCar details:\n" + tesla);
    }
}
