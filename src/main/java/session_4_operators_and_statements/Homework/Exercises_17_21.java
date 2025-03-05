package session_4_operators_and_statements.Homework;

import java.util.Scanner;

public class Exercises_17_21 {
    Scanner input = new Scanner(System.in);

    /*
       17. Write a Java program that simulates a simple authentication system.
           Declare a boolean variable hasUsername and hasPassword.
           Set up a series of logical conditions using these two variables that will check
           the following conditions:

                If both hasUsername and hasPassword are true, print "Authentication successful".
                If either hasUsername or hasPassword is false, print "Authentication failed".
                If hasUsername is true but hasPassword is false, print "Password is incorrect".
    */

    public void authenticationSystem(boolean hasUsername, boolean hasPassword) {
        if (hasUsername && hasPassword){
            System.out.println("Authentication successful");
        } else if (hasUsername && !hasPassword) {
            System.out.println("Password is incorrect");
        } else if (!hasUsername || !hasPassword) {
            System.out.println("Authentication failed");
        }
    }

    /*
       18. Write a Java program where you declare an integer array with 5 elements.
       Use a for loop to initialize the array such that each element is equal to its index incremented by 1.
       Then use another for loop to decrement each element by 1.
       Print the array before and after the decrement operation using a for-each loop.
    */

    public void incrementDecrementArray(){
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        System.out.println("Array before decrement: ");
        for (int val : arr){
            System.out.print(val + " ");
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] - 1;
        }

        System.out.println("\nArray after decrement: ");
        for (int val : arr){
            System.out.print(val + " ");
        }
    }

    /*
       19. Write a Java program that takes an integer variable age as input.
           Use a ternary operator to classify the person into one of the following categories:
               "Child" (age < 12), "Teenager" (age between 12 and 17),
               "Adult" (age between 18 and 64),
               and "Senior" (age 65 and above).
           Print the resulting classification.
    */

    public void getAgeCategory(){
        System.out.print("Please enter your age: ");
        int age = input.nextInt();

        String category = (age < 12) ? "Child" :
                            (age <= 17) ? "Teenager" :
                            (age <= 64) ? "Adult" : "Senior";

        System.out.println("You are " + (category.equals("Adult") ? "an " : "a ") + category);
    }

    /*
       20. Write a Java program that takes three integer variables a, b, and c as input.
           Use nested ternary operators to find and print the largest number among the three.
    */

    public int largestNumber(){
        System.out.print("Please enter three numbers:\n" +
                            "First number = ");
        int a = input.nextInt();

        System.out.print("Second number = ");
        int b = input.nextInt();

        System.out.print("Third number = ");
        int c = input.nextInt();

        return (a > b && a > c) ? a :
                (b > c && b > a) ? b : c;
    }

    /*
       21. Write a Java program that takes a double variable score representing a student’s score on a test.
           Use a ternary operator to classify the score into letter grades A, B, C, D, or F
           according to the following scale:

            A: 90-100
            B: 80-89
            C: 70-79
            D: 60-69
            F: 0-59

            Print the resulting letter grade.
    */

    public void classifyScore(double score){
        char grade = (score >= 0 && score <= 59) ? 'F' :
                        (score <= 69) ? 'D' :
                        (score <= 79) ? 'C' :
                        (score <= 89) ? 'B' :
                        (score <= 100) ? 'A' : '/';

        System.out.println("The student's grade is: " + grade);
    }
}
