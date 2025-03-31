package session_10_OOP.Homework.FitnessTrackingSystem;

import java.time.LocalDate;

public class Goal {
    private final String workout;
    private final LocalDate startDate;
    private double target;
    private boolean isMet;

    public Goal(String workout, LocalDate startDate, double target) {
        this.workout = workout;
        this.startDate = startDate;
        this.target = target;
        this.isMet = false;
    }

    public String getWorkout() {
        return workout;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public void setMet(boolean met) {
        isMet = met;
    }

    @Override
    public String toString() {
        return "Goal: " + workout + " target: " + target + (isMet ? " (Achieved)" : " (Not Achieved)");
    }
}
