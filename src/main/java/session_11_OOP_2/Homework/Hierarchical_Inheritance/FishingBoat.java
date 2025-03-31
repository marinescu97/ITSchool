package session_11_OOP_2.Homework.Hierarchical_Inheritance;

public class FishingBoat extends Boat{
    private double fishCapacity;
    private String typeOfNet;

    public FishingBoat(double length, double weight, double fishCapacity, String typeOfNet) {
        super(length, weight);
        this.fishCapacity = fishCapacity;
        this.typeOfNet = typeOfNet;
    }

    public double getFishCapacity() {
        return fishCapacity;
    }

    public void setFishCapacity(double fishCapacity) {
        this.fishCapacity = fishCapacity;
    }

    public String getTypeOfNet() {
        return typeOfNet;
    }

    public void setTypeOfNet(String typeOfNet) {
        this.typeOfNet = typeOfNet;
    }

    public void castNet() {
        System.out.println("Casting the " + typeOfNet + " to catch fish!");
    }

    @Override
    public String toString() {
        return String.format("""
                %s
                Fish capacity: %.1f
                Type of net: %s
                """, super.toString(), fishCapacity, typeOfNet);
    }
}
