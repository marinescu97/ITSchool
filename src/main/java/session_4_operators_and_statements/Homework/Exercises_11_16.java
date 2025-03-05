package session_4_operators_and_statements.Homework;

public class Exercises_11_16 {
    /*
       11. Write a Java program where you declare four integer variables: a, b, c, and d.
           Assign them values of 10, 20, 30, and 40 respectively.
           Create two more variables additionResult and multiplicationResult.
           Set additionResult to the sum of a and b and multiplicationResult to the product of c and d.
           Print the values of additionResult and multiplicationResult.
    */

    int a = 10;
    int b = 20;
    int c = 30;
    int d = 40;
    int additionResult, multiplicationResult;

    public void additionMultiplicationResult(){
        additionResult = a + b;
        multiplicationResult = c * d;

        System.out.println("Addition result = " + additionResult);
        System.out.println("Multiplication result = " + multiplicationResult);
    }

    /*
       12. Write a Java program where you declare an integer variable number with a value of 25.
           Use unary minus operator to change the sign of number and assign it to a variable negativeNumber.
           Print the values of number and negativeNumber.
    */

    public void negativeNumber(){
        int myNumber = 25;
        int negativeNumber = -myNumber;

        System.out.println("My number = " + myNumber);
        System.out.println("Negative number = " + negativeNumber);
    }

    /*
       13. Write a Java program where you declare two boolean variables isRaining and isSunny
           with values of true and false, respectively.
           Use the logical complement operator to negate the values of both variables and print the new values.
    */

    public void getWeather() {
        boolean isRaining = true;
        boolean isSunny = false;

        System.out.printf("Is raining: %b%n" +
                "Is sunny: %b%n", isRaining, isSunny);

        isRaining = !isRaining;
        isSunny = !isSunny;

        System.out.printf("After negate:%n" +
                "Is raining: %b%n" +
                "Is sunny: %b%n", isRaining, isSunny);
    }

    /*
       14. Write a Java program where you declare an integer variable counter with a value of 0.
           Use the increment operator to increase the value of counter by 1 and then print the value.
           After that, use the decrement operator to decrease the value of counter by 1
           and then print the value.
    */

    public void incrementDecrement(){
        int counter = 0;

        System.out.println("Incremented: " + ++counter);
        System.out.println("Decremented: " + --counter);
    }

    /*
       15. Write a Java program where you declare an integer variable total with a value of 100.
           Use the compound assignment operator to decrease the total by 20 and then print the value.
           Next, use another compound assignment operator to multiply the total by 2 and then print the value.
    */

    public void calculator(){
        int total = 100;

        total -= 20;

        System.out.println("Total after subtraction: " + total);

        total *= 2;

        System.out.println("Total after multiplication: " + total);
    }

    /*
    16. Write a Java program where you use unary operators to perform a series of transformations
        on an integer variable number initialized to 50.
        First, negate number, then take the absolute value, and finally increment it by 1.
        Print the result at each step.
     */

    public void transformNumber(){
        int number = 50;
        System.out.println("Initial number: " + number);

        number = -number;
        System.out.println("Negated number: " + number);

//        number = Math.abs(number);
        number = (number < 0) ? -number : number;
        System.out.println("Absolute value of the number: " + number);

        number++;
        System.out.println("Incremented: " + number);
    }
}
