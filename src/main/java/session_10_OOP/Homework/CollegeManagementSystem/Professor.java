package session_10_OOP.Homework.CollegeManagementSystem;

import java.time.LocalDate;

public class Professor extends Person{
    public Professor(String firstName, String lastName, Gender gender, LocalDate birthDate, String CNP, String address) {
        super(firstName, lastName, gender, birthDate, CNP, address);
    }
}
