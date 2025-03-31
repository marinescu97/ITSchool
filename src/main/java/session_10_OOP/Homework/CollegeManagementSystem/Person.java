package session_10_OOP.Homework.CollegeManagementSystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {
    private final String firstName;
    private final String lastName;
    private final Gender gender;
    private final int age;
    private final LocalDate birthDate;
    private final String CNP;
    private String address;

    public Person(String firstName, String lastName, Gender gender, LocalDate birthDate, String CNP, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = calculateAge();
        this.birthDate = birthDate;
        this.CNP = CNP;
        this.address = address;
    }

    private int calculateAge(){
        LocalDate currentDate = LocalDate.now();
        if (birthDate != null){
            return (int) ChronoUnit.YEARS.between(birthDate, currentDate);
        }
        return -1;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getCNP() {
        return CNP;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
