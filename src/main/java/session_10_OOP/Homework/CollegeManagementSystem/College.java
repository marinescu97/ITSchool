package session_10_OOP.Homework.CollegeManagementSystem;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Professor johnSmith = new Professor("John", "Smith", Gender.MALE, LocalDate.of(1980, 6, 23),
                "5783547589125", "123 Elm St, Springfield, IL 62701");
        Professor emilyJohnson = new Professor("Emily", "Johnson", Gender.FEMALE, LocalDate.of(1997, 3, 15),
                "3333666611112", "456 Oak Ave, Denver, CO 80202");

        Student sarahDavis = new Student("Sarah", "Davis", Gender.FEMALE, LocalDate.of(2000, 4, 17),
                "7424466998883", "101 Pine Ln, Seattle, WA 98101");
        Student jamesWilson = new Student("James", "Wilson", Gender.MALE, LocalDate.of(1997, 9, 10),
                "3333377777111", "202 Cedar Blvd, Miami, FL 33101");


        Course math = new Course(CourseName.MATH, "Monday 9:00 AM", 2, "Introduction to Mathematics");
        math.assignProfessor(johnSmith);
        math.addStudents(sarahDavis, jamesWilson);

        System.out.println(math);

        Course computerScience = new Course(CourseName.COMPUTER_SCIENCE, "Wednesday 06:00 PM", 2, "Introduction to Computer Science", emilyJohnson);
        System.out.println(computerScience);
    }
}
