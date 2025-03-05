package session_4_operators_and_statements.Homework;

public class Main {
    public static void main(String[] args) {
        Exercises_1_5 exercises_1_5 = new Exercises_1_5();

        System.out.println("1.");
        exercises_1_5.referToSameObject(exercises_1_5.stringOne, exercises_1_5.stringTwo);

        System.out.println("Using new keyword:");
        exercises_1_5.referToSameObject(exercises_1_5.newStringOne, exercises_1_5.newStringTwo);

        System.out.print("""
                
                2.
                Integer:
                """);
        exercises_1_5.areIntEqual(exercises_1_5.firstNumber, exercises_1_5.secondNumber);
        System.out.println("String:");
        exercises_1_5.areStringEqual(exercises_1_5.stringOne, exercises_1_5.stringTwo);

        System.out.println("\n3.");
        exercises_1_5.checkAge();

        System.out.printf("""
                
                4.
                The maximum height is: %d
                """, exercises_1_5.findMaximumHeight());

        System.out.println("\n5.");
        exercises_1_5.printNumbers();

        Exercises_6_10 exercises_6_10 = new Exercises_6_10();

        System.out.println("\n\n6.");
        exercises_6_10.checkTemperature();

        System.out.println("\n7.");
        System.out.printf("The triangle is %s", exercises_6_10.typeOfTriangle());

        System.out.println("\n\n8.");
        int myNumber = 6;
        System.out.printf("The factorial of the number %d is %d", myNumber, exercises_6_10.factorial(myNumber));

        System.out.println("\n\n9.");
        exercises_6_10.checkEquality();

        System.out.println("\n10.");
        exercises_6_10.checkLists();

        Exercises_11_16 exercises_11_16 = new Exercises_11_16();

        System.out.println("\n11.");
        exercises_11_16.additionMultiplicationResult();

        System.out.println("\n12.");
        exercises_11_16.negativeNumber();

        System.out.println("\n13.");
        exercises_11_16.getWeather();

        System.out.println("\n14.");
        exercises_11_16.incrementDecrement();

        System.out.println("\n15.");
        exercises_11_16.calculator();

        System.out.println("\n16.");
        exercises_11_16.transformNumber();

        Exercises_17_21 exercises_17_21 = new Exercises_17_21();

        System.out.println("\n17.");
        exercises_17_21.authenticationSystem(true, false);

        System.out.println("\n18.");
        exercises_17_21.incrementDecrementArray();

        System.out.println("\n\n19.");
        exercises_17_21.getAgeCategory();

        System.out.println("\n20.");
        System.out.println("The largest number is: " + exercises_17_21.largestNumber());

        System.out.println("\n21.");
        exercises_17_21.classifyScore(60);
    }
}
