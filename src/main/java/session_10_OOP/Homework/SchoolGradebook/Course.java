package session_10_OOP.Homework.SchoolGradebook;

import java.util.*;

public class Course {
    private String name;
    private Map<Student, List<Double>> students;

    public Course(String name){
        this.name = name;
        this.students = new TreeMap<>();
    }

    public void displayStudents(){
        for (Student student : students.keySet()){
            System.out.println(student);
        }
    }

    public void displayStudentsWithGrades() {
        for (Student student : students.keySet()){
            System.out.print(student + ": ");
            for (Double grade : students.get(student)){
                System.out.print(grade + " ");
            }
            System.out.println();
        }
    }

    public void addStudent(Student student){
        if (isStudentPresent(student)){
            System.out.println("The student " + student.getName() + " is already in the list.");
        } else {
            students.put(student, new ArrayList<>());
            System.out.println("Student " + student.getName() + " added successfully.");
        }
    }

    public void assignGrade(Student student, double grade){
        if (isStudentPresent(student)){
            students.get(student).add(grade);
            System.out.println("Grade " + grade + " for student " + student.getName() + " added successfully.");
        } else {
            System.out.println("The student " + student.getName() + " is not in the list.");
        }
    }

    private boolean isStudentPresent(Student student){
        return students.containsKey(student);
    }

    public double calculateAvgGrade(Student student){
        if (isStudentPresent(student)){
            List<Double> grades = students.get(student);
            double sum = 0;

            for (double grade : grades){
                sum += grade;
            }

            return (double) Math.round((sum / grades.size()) * 100) / 100;
        }

        System.out.println("The student " + student.getName() + " is not in the list.");
        return 0;
    }

    public void displayStudentsWithAvgGrades(){
        for (Student student : students.keySet()){
            System.out.println(student + ": " + calculateAvgGrade(student));
        }
    }
}
