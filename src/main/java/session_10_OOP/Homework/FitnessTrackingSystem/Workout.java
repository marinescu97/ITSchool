package session_10_OOP.Homework.FitnessTrackingSystem;

import java.time.LocalDate;

public class Workout {
    private final LocalDate date;

    public Workout(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
