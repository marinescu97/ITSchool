package session_26_Exceptions.Homework.AgeValidation;

import java.util.Scanner;

public class ValidateAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Please enter you age: ");
            int age = scanner.nextInt();
            validateAge(age);
            System.out.println("The age is valid.");
        } catch (InvalidAgeException e){
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 150){
            throw new InvalidAgeException("Invalid age!");
        }
    }
}
