package session_10_OOP.Homework.CollegeManagementSystem;

import java.time.LocalDate;

public class Student extends Person{

    public Student(String firstName, String lastName, Gender gender, LocalDate birthDate, String CNP, String address) {
        super(firstName, lastName, gender, birthDate, CNP, address);
    }
}
