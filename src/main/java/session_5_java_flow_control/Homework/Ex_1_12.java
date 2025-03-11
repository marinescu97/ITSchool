package session_5_java_flow_control.Homework;

import java.util.Random;
import java.util.Scanner;

public class Ex_1_12 {

    private static final Scanner input = new Scanner(System.in);

    /*
        1. Even or Odd Checker
           Write a Java program that takes an integer as input.
           If the number is even, print "Even".
           If it's odd, print "Odd".
     */

    public static void evenOrOddChecker(){
        System.out.print("Ex. 1 - Even or Odd Checker\n" +
                            "Please insert a number: ");
        int number = input.nextInt();

        if (number % 2 == 0){
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }

    /*
        2. Month Name Finder
           Write a program that asks the user to enter a number between 1 and 12.
           Print the name of the corresponding month or "Invalid Month" if out of range.
     */

    public static void monthNameFinder(){
        System.out.print("""
                Ex.2 - Month Name Finder
                Please insert a number between 1 and 12:\s""");
        int number = input.nextInt();

        switch (number){
            case 1 -> System.out.println("January");
            case 2 -> System.out.println("February");
            case 3 -> System.out.println("March");
            case 4 -> System.out.println("April");
            case 5 -> System.out.println("May");
            case 6 -> System.out.println("June");
            case 7 -> System.out.println("July");
            case 8 -> System.out.println("August");
            case 9 -> System.out.println("September");
            case 10 -> System.out.println("October");
            case 11 -> System.out.println("November");
            case 12 -> System.out.println("December");
            default -> System.out.println("Invalid Month");
        }
    }

    /*
        3. Counting Negative Numbers
           Given an array of integers, write a program to count and print the number of negative integers
           in the array.
    */
    public static void countingNegativeNumbers(int[] array){
        System.out.println("Ex. 3 - Counting Negative Numbers");

        int counter = 0;

        for (int number : array){
            if (number < 0){
                counter++;
            }
        }

        System.out.println("The number of negative numbers is: " + counter);
    }

    /*
        4. String Reverser
           Ask the user to enter a string. Print the reversed version of this string.
    */

    public static void stringReverser(){
        System.out.print("Ex. 4 - String Reverser" +
                        "Please insert a word: ");
        String word = input.nextLine();
        String reversedWord = "";

        while (!word.isEmpty()){
            reversedWord += word.charAt(word.length() - 1);

            word = word.substring(0, word.length() - 1);
        }
        System.out.println("The reversed word is: " + reversedWord);
    }

    /*
        5. Fibonacci Series Generator
           Write a program that generates and prints the first n numbers of the Fibonacci series,
           where n is provided by the user.
    */

    public static void fibonacciSeriesGenerator(){
        System.out.print("""
                Ex. 5 - Fibonacci Series Generator
                Please insert a number:\s""");
        int number = input.nextInt();

        int firstNumber = 0, secondNumber = 1;

        int sum;

        System.out.printf("%d %d ", firstNumber, secondNumber);

        for (int i = 0; i < number - 2; i++) {
            sum = firstNumber + secondNumber;
            System.out.print(sum + " ");
            firstNumber = secondNumber;
            secondNumber = sum;
        }
    }

    /*
        6. While Loop
           Write a program that asks the user to enter numbers.
           The program should continue prompting the user until they enter -1.
           After they enter -1, print the sum of all numbers entered (excluding -1).
    */

    public static void printSumWhileLoop(){
        System.out.println("""
                Ex. 6 - Print Sum While Loop
                """);

        int number = 0, sum = 1;

        while (number != -1){
            System.out.print("Please insert -1 to exit or any number to continue: ");
            number = input.nextInt();

            sum += number;
        }

        System.out.println("The sum of the numbers is: " + sum);
    }

    /*
        7. Do-While Loop
           Create a program where the user is prompted to guess a predefined number.
           After each guess, the program should inform the user if the guess is too high or too low.
           The program should keep prompting the user until they guess correctly.
           Using a do-while loop, ensure the user is always asked at least once.
    */

    public static void numberGuessingGame(){
        System.out.println("""
                Ex. 7 - Number Guessing Game
                """);
        Random random = new Random();
        int number = random.nextInt(1, 101);
        int insertedNumber;

        do {
            System.out.print("Please insert a number between 1 and 100: ");
            insertedNumber = input.nextInt();

            if (insertedNumber < number){
                System.out.println("The number is too low");
            } else if (insertedNumber > number) {
                System.out.println("The number is too high");
            } else {
                System.out.println("The number is correct");
            }

        } while (insertedNumber != number);
    }

    /*
        8. For Loop
           Write a program that prints the first 10 numbers in the Fibonacci series.
           Use a for loop to accomplish this.
    */

    public static void fibonacciSeries(){
        System.out.println("Ex. 8 - Fibonacci Series");

        int firstNumber = 0, secondNumber = 1;
        System.out.print(firstNumber + " " + secondNumber + " ");
        int sum;
        for (int i = 0; i < 8; i++) {
            sum = firstNumber + secondNumber;
            System.out.print(sum + " ");

            firstNumber = secondNumber;
            secondNumber = sum;
        }
    }

    /*
        9. For-Each Loop
           Given an array of integers, write a program that prints each number in the array
           followed by "Even" if the number is even, or "Odd" if the number is odd.
           Utilize a for-each loop for this task.
    */

    public static void printEvenOrOdd(int[] array){
        System.out.println("\nEx. 9 - Print Even Or Odd For-Each Loop");

        for (int number : array){
            if (number % 2 == 0){
                System.out.println(number + " - Even");
            } else {
                System.out.println(number + " - Odd");
            }
        }
    }

    /*
        10. Jump Statements
        Create a menu-driven program where the user is presented with options:
            Print "Hello World"
            Print the user's name.
            Exit.
        Based on the user's input, perform the necessary action.
        Once an action is completed, show the menu again, unless the user chooses the Exit option.
        Use jump statements to control the flow of the program.
    */

    public static void showMenu(){
        System.out.print("Please enter your name: ");
        String name = input.nextLine();
        String inserted;

        while (true){
            System.out.println("""
                    1 - Print "Hello World"
                    2 - Print the user's name
                    0 - Exit.
                    """);
            inserted = input.nextLine();
            if (inserted.equals("1")){
                System.out.println("Hello World\n");
            } else if (inserted.equals("2")) {
                System.out.println(name + "\n");
            } else if (inserted.equals("0")) {
                break;
            } else {
                System.out.println("Invalid input\n");
            }
        }
    }

    /*
        11. Break Statement
        Write a program that prompts the user to enter numbers.
        Calculate the average of these numbers.
        If the user enters 0, break out of the input loop and then print the average of the numbers
        entered so far.
    */

    public static void printAverageNumbers(){
        System.out.println("\nEx. 11 - Print Average Numbers Break Statement");
        double sum = 0d, counter = 0, number;

        while (true){
            System.out.print("Please insert 0 to exit or any number: ");
            number = input.nextInt();

            if (number == 0){
                break;
            } else {
                sum += number;
                counter++;
            }
        }
        double avg = (double) Math.round((sum / counter) * 100) / 100;
        System.out.println("The average of the numbers is: " + avg);
    }

    /*
        12. Continue Statement
            Create a program that asks the user for 10 numbers.
            Print the sum of all numbers that are greater than 5.
            If the user enters a number less than or equal to 5, use the continue statement
            to skip the addition for that number.
    */

    public static void printSumOfNumbers(){
        System.out.println("Ex. 12 - Print Sum Of Numbers Continue Statement\n");
        int number, sum = 0;

        for (int i = 0; i < 10; i++){
            System.out.print("Please insert a number: ");
            number = input.nextInt();

            if (number > 5){
                sum += number;
            } else {
                continue;
            }
        }

        System.out.println("The sum of the numbers is: " + sum);
    }
}
