package session_11_OOP_2.Homework.Hierarchical_Inheritance;

public class TestBoat {
    public static void main(String[] args) {
        Boat boat = new Boat(12.5d, 3500d);

        boat.sail();

        System.out.println(boat + "\n");

        SpeedBoat speedBoat = new SpeedBoat(boat.getLength(), boat.getWeight(), 80d, "V8");
        speedBoat.sail();
        speedBoat.turboBoost();
        System.out.println(speedBoat);

        FishingBoat fishingBoat = new FishingBoat(15.0, 2000, 500, "Seine net");
        fishingBoat.sail();
        fishingBoat.castNet();

        System.out.println(fishingBoat);
    }
}
