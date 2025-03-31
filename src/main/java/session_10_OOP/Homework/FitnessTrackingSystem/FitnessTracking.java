package session_10_OOP.Homework.FitnessTrackingSystem;

import java.time.LocalDate;

public class FitnessTracking {
    public static void main(String[] args) {
        User janeSmith = new User("Jane Smith");

        janeSmith.logWorkout("Weightlifting", LocalDate.of(2025, 3, 23), 15d);
        janeSmith.logWorkout("Yoga", LocalDate.of(2025, 3, 24), 120d);
        janeSmith.logWorkout("Running", LocalDate.of(2025, 3, 25), 3d);
        janeSmith.logWorkout("Yoga", LocalDate.of(2025, 3, 25), 7d);
        janeSmith.logWorkout("Yoga", LocalDate.of(2025, 3, 29), 20d);

        janeSmith.setGoal("Running", LocalDate.of(2025, 3, 24), 10d);
        janeSmith.setGoal("Running", LocalDate.of(2025, 3, 28), 20d);
        janeSmith.setGoal("Yoga", LocalDate.of(2025, 3, 27), 130d);

        System.out.println("Workouts by type:");
        for (Workout workout : janeSmith.getWorkoutsByType("Yoga")){
            System.out.println(workout);
        }

        System.out.println("\nWorkouts by date:");
        for (Workout workout : janeSmith.getWorkoutByDate(LocalDate.of(2025, 3, 25))){
            System.out.println(workout);
        }

        System.out.println("\nSummary");
        janeSmith.getSummary();
    }
}
