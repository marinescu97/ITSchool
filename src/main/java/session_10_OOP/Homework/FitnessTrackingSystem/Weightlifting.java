package session_10_OOP.Homework.FitnessTrackingSystem;

import java.time.LocalDate;

public class Weightlifting extends Workout{
    private final double weightliftedInKg;

    public Weightlifting(LocalDate date, double weightliftedInKg) {
        super(date);
        this.weightliftedInKg = weightliftedInKg;
    }

    public double getWeightliftedInKg() {
        return weightliftedInKg;
    }

    @Override
    public String toString() {
        return super.toString() + " -> " + weightliftedInKg + " kg";
    }
}
