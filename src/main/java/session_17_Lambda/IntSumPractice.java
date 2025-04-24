package session_17_Lambda;

import java.util.function.Consumer;

public class IntSumPractice {
    public static void main(String[] args) {
        IntSum result = (a, b) -> a + b;
        System.out.println(result.sum(1, 2));
    }
}

class IntMultiplyPractice{
    public static void main(String[] args) {
        IntMultiply result = (a, b) -> a * b;
        System.out.println(result.multiply(2, 3));
    }
}

class CalculatorPractice{
    public static void main(String[] args) {
        Calculator sum = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;
        Calculator subtraction = (a, b) -> a - b;
        Calculator division = (a, b) -> a / b;

        System.out.println("Sum: " + sum.compute(2, 3));
        System.out.println("Multiply: " + multiply.compute(2, 3));
        System.out.println("Subtraction: " + subtraction.compute(6, 3));
        System.out.println("Division: " + division.compute(6, 3));
    }
}

class LambdaExample{
    public static void main(String[] args) {
        Runnable noParam = () -> System.out.println("From Runnable");
        noParam.run();

        Consumer<String> oneParam = msg -> System.out.println("Message: " + msg);
        oneParam.accept("from consumer");
    }
}
