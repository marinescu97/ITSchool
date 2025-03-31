package session_10_OOP.Homework.CollegeManagementSystem;

import java.util.ArrayList;
import java.util.Arrays;

public class Course {
    private final CourseName name;
    private final String schedule;
    private final int durationHours;
    private final String description;
    private Professor professor;
    private final ArrayList<Student> students;

    public Course(CourseName name, String schedule, int durationHours, String description, Professor professor) {
        this.name = name;
        this.schedule = schedule;
        this.durationHours = durationHours;
        this.description = description;
        this.professor = professor;
        students = new ArrayList<>();
    }

    public Course(CourseName name, String schedule, int durationHours, String description) {
        this.name = name;
        this.schedule = schedule;
        this.durationHours = durationHours;
        this.description = description;
        students = new ArrayList<>();
    }

    public void assignProfessor(Professor professor){
        this.professor = professor;
        System.out.printf("Professor %s %s assigned to the %s course.%n", professor.getFirstName(), professor.getLastName(), name);
    }

    public void addStudents(Student... students){
        this.students.addAll(Arrays.asList(students));
        System.out.println("List of students added successfully");
    }

    @Override
    public String toString() {
        return String.format("""
                %s Course
                Professor: %s
                Schedule: %s
                Duration: %d
                Description: %s
                Students: %s
                """, name, professor, schedule, durationHours, description, students.isEmpty() ? "There are no students for this course." : students);
    }
}
