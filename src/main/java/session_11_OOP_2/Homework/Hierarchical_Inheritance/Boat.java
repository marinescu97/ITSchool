package session_11_OOP_2.Homework.Hierarchical_Inheritance;

public class Boat {
    private double length;
    private double weight;

    public Boat(double length, double weight) {
        this.length = length;
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }

    public void sail(){
        System.out.println("The " + this.getClass().getSimpleName() + " is sailing.");
    }

    @Override
    public String toString() {
        return String.format("""
                %s
                Length: %.1f
                Weight: %.1f""", this.getClass().getSimpleName(), length, weight);
    }
}
