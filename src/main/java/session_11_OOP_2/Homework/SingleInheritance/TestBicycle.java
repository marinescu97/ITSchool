package session_11_OOP_2.Homework.SingleInheritance;

public class TestBicycle {
    public static void main(String[] args) {
        MountainBike mountainBike = new MountainBike("Mountain", "Soft");

        mountainBike.display();
        System.out.println();
        mountainBike.speedUp(10);
        System.out.println();
        mountainBike.applyBrake(5);
        System.out.println();
        mountainBike.speedUp(25);
        System.out.println();
        mountainBike.applyBrake(10);
    }
}
