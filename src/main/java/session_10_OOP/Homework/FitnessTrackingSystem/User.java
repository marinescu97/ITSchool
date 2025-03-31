package session_10_OOP.Homework.FitnessTrackingSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private final List<Workout> workouts;
    private final List<Goal> goals;

    public User(String name) {
        this.name = name;
        this.workouts = new ArrayList<>();
        this.goals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void logWorkout(String type, LocalDate date, double metric){
        switch (type){
            case "Running" -> workouts.add(new Running(date, metric));
            case "Yoga" -> workouts.add(new Yoga(date, (int) metric));
            case "Weightlifting" -> workouts.add(new Weightlifting(date, metric));
        }
    }

    public List<Workout> getWorkoutsByType(String type){
        List<Workout> result = new ArrayList<>();

        for (Workout workout : workouts){
            if (workout.getClass().getSimpleName().equalsIgnoreCase(type)){
                result.add(workout);
            }
        }

        return result;
    }

    public List<Workout> getWorkoutByDate(LocalDate date){
        List<Workout> result = new ArrayList<>();

        for (Workout workout : workouts){
            if (workout.getDate().equals(date)){
                result.add(workout);
            }
        }

        return result;
    }

    public void setGoal(String type, LocalDate startDate, double target){
        List<Goal> lastGoals = getLastGoals();

        lastGoals.removeIf(goal -> !goal.getWorkout().equals(type));

        if (lastGoals.isEmpty()){
            goals.add(new Goal(type, startDate, target));
        } else {
            lastGoals.getFirst().setTarget(target);
        }
    }

    private void showPastWorkouts(){
        System.out.println("Workouts:");
        for (Workout workout : workouts){
            if (workout.getDate().isAfter(LocalDate.now().minusWeeks(1)) || workout.getDate().isEqual(LocalDate.now().minusWeeks(1))){
                System.out.println(workout);
            }
        }
        System.out.println();
    }

    private List<Goal> getLastGoals(){
        List<Goal> lastGoals = new ArrayList<>();

        for (Goal goal : goals){
            if (goal.getStartDate().isAfter(LocalDate.now().minusWeeks(1)) || goal.getStartDate().isEqual(LocalDate.now().minusWeeks(1))){
                lastGoals.add(goal);
            }
        }

        return lastGoals;
    }

    private List<Workout> getLastWorkouts(){
        List<Workout> lastWorkouts = new ArrayList<>();

        for (Workout workout : workouts){
            if (workout.getDate().isAfter(LocalDate.now().minusWeeks(1)) || workout.getDate().isEqual(LocalDate.now().minusWeeks(1))){
                lastWorkouts.add(workout);
            }
        }

        return lastWorkouts;
    }

    private void checkMetGoal(){
        double totalRunningDistance = 0;
        double totalWeightLifted = 0;
        double totalYogaDuration = 0;

        for (Workout workout : getLastWorkouts()) {
            if (workout instanceof Running) {
                totalRunningDistance += ((Running) workout).getDistanceInKm();
            } else if (workout instanceof Weightlifting) {
                totalWeightLifted += ((Weightlifting) workout).getWeightliftedInKg();
            } else if (workout instanceof  Yoga) {
                totalYogaDuration += ((Yoga) workout).getDurationInMinutes();
            }
        }

        List<Goal> lastGoals = getLastGoals();

        for (Goal goal : lastGoals) {
            switch (goal.getWorkout()) {
                case "Running" -> goal.setMet(totalRunningDistance >= goal.getTarget());
                case "Weightlifting" -> goal.setMet(totalWeightLifted >= goal.getTarget());
                case "Yoga" -> goal.setMet(totalYogaDuration >= goal.getTarget());
            }
        }

        for (Goal goal : lastGoals) {
            System.out.println(goal);
        }
    }

    public void getSummary(){
        showPastWorkouts();
        checkMetGoal();
    }
}
