package session_10_OOP.Homework.FitnessTrackingSystem;

import java.time.LocalDate;

public class Yoga extends Workout{
    private final double durationInMinutes;

    public Yoga(LocalDate date, double durationInMinutes) {
        super(date);
        this.durationInMinutes = durationInMinutes;
    }

    public double getDurationInMinutes() {
        return durationInMinutes;
    }

    @Override
    public String toString() {
        return super.toString() + " -> " + durationInMinutes + " minutes";
    }
}
