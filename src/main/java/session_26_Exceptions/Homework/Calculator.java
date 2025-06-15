package session_26_Exceptions.Homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please enter the first number: ");
            double firstNumber = scanner.nextDouble();

            System.out.print("Please enter the second number: ");
            double secondNumber = scanner.nextDouble();

            System.out.print("Please enter the operator (+ - * / %): ");
            char operator = scanner.next().charAt(0);

            System.out.println("Result: " + calculate(firstNumber, secondNumber, operator));
        } catch (NumberFormatException | InputMismatchException e){
            System.out.println("Invalid input!");
        } catch (ArithmeticException | IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static double calculate(double firstNumber, double secondNumber, char operator){
        double result;
        switch (operator){
            case '+' -> result = firstNumber + secondNumber;
            case '-' -> result = firstNumber - secondNumber;
            case '*' -> result = firstNumber * secondNumber;
            case '/' -> result = performDivision(firstNumber, secondNumber);
            case '%' -> result = firstNumber % secondNumber;
            default -> throw new IllegalArgumentException("Invalid operator!");
        }

        return result;
    }

    private static double performDivision(double a, double b){
        if (b == 0){
            throw new ArithmeticException("Cannot divide by 0.");
        }
        return a / b;
    }
}
