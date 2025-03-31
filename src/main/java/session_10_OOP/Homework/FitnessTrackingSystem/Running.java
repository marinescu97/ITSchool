package session_10_OOP.Homework.FitnessTrackingSystem;

import java.time.LocalDate;

public class Running extends Workout {
    private final double distanceInKm;

    public Running(LocalDate date, double distanceInKm) {
        super(date);
        this.distanceInKm = distanceInKm;
    }

    public double getDistanceInKm() {
        return distanceInKm;
    }

    @Override
    public String toString() {
        return super.toString() + " -> " + distanceInKm + " km";
    }
}
