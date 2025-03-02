package main.java.session_3_java_operators;

import java.util.Scanner;

public class Homework {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*
           1. Write a Java program to take two numbers as input and display the result of addition, subtraction, multiplication, division, and modulus.
        */

        System.out.println("1.\nPlease enter two numbers");

        System.out.print("First number: ");
        int firstNumber = scanner.nextInt();

        System.out.print("Second number: ");
        int secondNumber = scanner.nextInt();

        System.out.println("Addition: " + (firstNumber + secondNumber));
        System.out.println("Subtraction: " + (firstNumber - secondNumber));
        System.out.println("Multiplication: " + (firstNumber * secondNumber));
        System.out.println("Division: " + (firstNumber / secondNumber));
        System.out.println("Modulus: " + (firstNumber % secondNumber));
        System.out.println("-------------------------");

        /*
           2. Create a Java program where you increment and decrement the same variable.
              Display the value of the variable after each operation.
        */

        int incrementDecrementVar = 5;

        System.out.println("2.\nThe initial number: " + incrementDecrementVar);
        System.out.println("Incremented: " + ++incrementDecrementVar);
        System.out.println("Decremented: " + --incrementDecrementVar);
        System.out.println("-------------------------");

        /*
           3. Write a program to check if a number is positive or negative using logical complement operator.
        */

        System.out.print("3.\nPlease enter a number: ");
        firstNumber = scanner.nextInt();

        if (!(firstNumber < 0)){
            System.out.println("The number is positive");
        } else {
            System.out.println("The number is negative");
        }
        System.out.println("-------------------------");

        /*
           4. Write a Java program that uses both the increment (++) and decrement (--) operators in a loop to count up to 10 and then back down to 1.
        */

        System.out.println("4.");

        int myNumber = 1;

        for (int i = 0; i < 9; i++){
            System.out.println("\t" + myNumber++);
        }

        for (int i = 0; i < 10; i++){
            System.out.println("\t" + myNumber--);
        }

        System.out.println("-------------------------");

        /*
           5. Create a Java program that demonstrates the use of each compound assignment operator with integers.
        */

        System.out.println("5.");
        firstNumber = 5;
        secondNumber = 6;

        firstNumber += secondNumber; // firstNumber = firstNumber + secondNumber = 5 + 6 = 11
        System.out.println("firstNumber += secondNumber: " + firstNumber);

        firstNumber -= secondNumber; // firstNumber = firstNumber - secondNumber = 11 - 6 = 5
        System.out.println("firstNumber -= secondNumber: " + firstNumber);

        firstNumber *= secondNumber; // firstNumber = firstNumber * secondNumber = 5 * 6 = 30
        System.out.println("firstNumber *= secondNumber: " + firstNumber);

        firstNumber /= secondNumber; // firstNumber = firstNumber / secondNumber = 30 / 6 = 5
        System.out.println("firstNumber /= secondNumber: " + firstNumber);

        firstNumber = 32;

        firstNumber %= secondNumber; // firstNumber = firstNumber % secondNumber = 32 % 6 = 2
        System.out.println("firstNumber %= secondNumber: " + firstNumber);

        firstNumber &= secondNumber; // firstNumber = firstNumber & secondNumber = 2 & 6
                                     //             = 0010 & 0110 (binary value)
                                     //             = 0010 = 2
        System.out.println("firstNumber &= secondNumber: " + firstNumber);

        firstNumber ^= secondNumber; // firstNumber = firstNumber ^ secondNumber = 2 ^ 6
                                     //             = 0010 ^ 0110 (binary value)
                                     //             = 0100 = 4
        System.out.println("firstNumber ^= secondNumber: " + firstNumber);

        boolean isNotEqual = firstNumber != secondNumber; // isNotEqual = firstNumber is not equal to secondNumber = true
        System.out.println("firstNumber != secondNumber: " + isNotEqual);

        firstNumber = 6;
        secondNumber = 3;
        firstNumber <<= secondNumber; // firstNumber = firstNumber << secondNumber = 6 << 3 = 0110000 = 48
        System.out.println("firstNumber <<= secondNumber: " + firstNumber);

        firstNumber = 20;
        firstNumber >>= secondNumber; // firstNumber = firstNumber >> secondNumber = 10100 >> 3 = 00010 = 2
        System.out.println("firstNumber >>= secondNumber: " + firstNumber);

        firstNumber = 8;
        secondNumber = 2;
        firstNumber >>>= secondNumber; // firstNumber = firstNumber >>> secondNumber = 8 >>> 2 = 1000 >>> 2 = 0010 = 2
        System.out.println("firstNumber >>>= secondNumber: " + firstNumber);

        System.out.println("-------------------------");

        /*
           6. Write a Java program that takes two numbers from the user and uses relational operators
              to display whether the first number is greater than, less than, or equal to the second number.
        */

        System.out.println("6.\nPlease enter two numbers: ");
        System.out.print("First number: ");
        firstNumber = scanner.nextInt();
        System.out.print("Second number: ");
        secondNumber = scanner.nextInt();

        if (firstNumber > secondNumber){
            System.out.println("The first number is greater than the second number.");
        } else if (firstNumber < secondNumber) {
            System.out.println("The first number is less than the second number.");
        } else {
            System.out.println("The first number is equal to the second number.");
        }

        System.out.println("-------------------------");

        /*
            7. Write a program where you perform operations between an integer and a double. Display the result.
        */

        System.out.println("7.");

        int myInteger = 3;
        double myDouble = 2.5d;

        System.out.println("Integer = " + myInteger);
        System.out.println("Double = " + myDouble);
        System.out.println("Addition: " + (myInteger + myDouble));
        System.out.println("Subtraction: " + (myInteger - myDouble));
        System.out.println("Multiplication: " + (myInteger * myDouble));
        System.out.println("Division: " + (myInteger / myDouble));
        System.out.println("Modulus: " + (myInteger % myDouble));
        System.out.println("-------------------------");

        /*
           8. Create a program that takes two byte values, adds them together, and stores the result in a byte variable.
        */

        System.out.println("8.");

        byte firstByteVal = 10;
        byte secondByteVal = 20;
        byte resultByte = (byte) (firstByteVal + secondByteVal);

        System.out.printf("""
                First byte value = %d
                Second byte value = %d
                ResultByte = %d
                -------------------------
                """, firstByteVal, secondByteVal, resultByte);

        /*
           9. Write a program that calculates the area of a rectangle. Take the length and breadth as inputs.
        */

        System.out.println("9.\nArea of a rectangle: ");
        System.out.print("Length = ");
        double length = scanner.nextDouble();

        System.out.print("Breadth = ");
        double breadth = scanner.nextDouble();

        System.out.println("Area: " + (length * breadth));
        System.out.println("-------------------------");

        /*
           10. Write a program that reverses the sign of an entered integer using unary minus operator.
        */

        System.out.print("10.\nPlease enter a number: ");
        myNumber = scanner.nextInt();

        System.out.println("Reversed number: " + (-myNumber));
        System.out.println("-------------------------");

        /*
           11. Write a Java program that takes two boolean inputs from a user.
               Apply the logical negation operator (!) to each and print the result.
        */

        System.out.println("11.\nPlease enter two booleans: ");

        System.out.print("First boolean: ");
        boolean firstBoolean = scanner.nextBoolean();

        System.out.print("Second boolean: ");
        boolean secondBoolean = scanner.nextBoolean();

        System.out.printf("!First boolean: %b%n" +
                          "!Second boolean: %b%n" +
                          "-------------------------%n", !firstBoolean, !secondBoolean);

        /*
           12. Create a program that takes an integer as input and then increments and decrements it by 1,
               displaying the output at each stage.
        */

        System.out.print("12.\nPlease enter a number: ");
        myNumber = scanner.nextInt();

        System.out.println("Incremented number: " + (++myNumber));
        System.out.println("Decremented previous number: " + (--myNumber));
        System.out.println("-------------------------");

        /*
           13. Write a program to calculate the price after discount.
               Take the original price and discount percentage as input.
               Use compound assignment operator to perform the calculation.
        */

        System.out.print("13.\nPrice: ");
        double price = scanner.nextDouble();

        System.out.print("Discount: ");
        float discount = scanner.nextFloat();

        price -= price * discount * 0.01f;
        double finalPrice = (double) Math.round(price * 100) / 100;
        System.out.println("Final price: " + finalPrice);
        System.out.println("-------------------------");

        /*
           14. Create a program that checks if a user entered number is within a specific range (e.g., 1-100).
               Use relational operators for the checks.
        */

        System.out.print("14.\nPlease enter a number: ");
        myNumber = scanner.nextInt();

        if (myNumber >= 1 && myNumber <= 50){
            System.out.println("The number is within the range 1-50");
        } else {
            System.out.println("The number is NOT within the range 1-50");
        }
    }
}
