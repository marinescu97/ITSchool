package main.java.session_1_java_basics;

import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        /* Simple Output Program:
           Write a program that prints your name, age, and favorite color on three separate lines. */

        String firstName = "Monica";
        String lastName = "Marinescu";
        int age = 27;
        String favoriteColor = "blue";

        System.out.println("My name is " + firstName + " " + lastName + '.');
        System.out.println("I'm " + age + " years old.");
        System.out.println("My favorite color is " + favoriteColor + ".\n");

        /* Using Variables:
           Write a program that defines four different variables (an integer, a double, a character, and a string),
           assigns them values, and then prints them out.
        */

        int myIntVal = 57;
        double myDoubleVal = 4.625d;
        char myCharVal = 'n';
        String myStringVal = "This is a sentence.";

        System.out.printf("""
                Integer: %d
                Double: %f
                Character: %c
                String: %s
                
                """, myIntVal, myDoubleVal, myCharVal, myStringVal);

        /*
            Operations:
            Write a program that performs various operations (addition, subtraction, multiplication, division, and modulus) on two numbers.
            The numbers can be hard-coded into the program. Print the result of each operation.
         */

        int firstNumber = 78;
        int secondNumber = 56;

        int addition = firstNumber + secondNumber;
        int subtraction = firstNumber - secondNumber;
        int multiplication = firstNumber * secondNumber;
        int division = firstNumber / secondNumber;
        int remainder= firstNumber % secondNumber;

        System.out.printf("""
                First number = %d
                Second number = %d
                ------------------
                Addition: %d
                Subtraction: %d
                Multiplication: %d
                Division: %d
                Remainder: %d
                
                """, firstNumber, secondNumber, addition, subtraction, multiplication, division, remainder);

        /*
            Simple Input/Output:
            Write a program that asks the user to enter two numbers, performs addition on those numbers, and prints out the result.
         */

        Scanner scn = new Scanner(System.in);

        System.out.println("Please enter two numbers:");

        System.out.print("First number = ");
        firstNumber = scn.nextInt();

        System.out.print("Second number = ");
        secondNumber = scn.nextInt();
        scn.nextLine();

        int result = firstNumber + secondNumber;

        System.out.println("Result: " + result);
    }
}
