package session_4_operators_and_statements.Homework;

public class Exercises_1_5 {
    String stringOne = "OpenAI";
    String stringTwo = "OpenAI";

    String newStringOne = new String("OpenAI");
    String newStringTwo = new String("OpenAI");

    int firstNumber = 5;
    int secondNumber = 8;

    int age = 20;

    int heightOne = 170;
    int heightTwo = 180;

    /*
       1. Write a Java program where you create two String objects named stringOne and stringTwo
          with the same value "OpenAI".
          Check and print whether they refer to the same object.
    */

    public void referToSameObject(String firstString, String secondString){
        if (firstString == secondString){
            System.out.println("They refer to the same object");
        } else {
            System.out.println("They don't refer to the same object");
        }
    }

    /*
       2.  Write a Java program to declare two integer variables firstNumber and secondNumber
           with any values.
           Use an equality operator to compare these two numbers and print the result.
           Do the same for two String objects firstString and secondString with the same value,
           but use the equals() method for comparison. Print the result.
    */

    public void areIntEqual(int firstNumber, int secondNumber){
        if (firstNumber == secondNumber){
            System.out.println("The two integers are equal.");
        } else {
            System.out.println("The two integers are not equal.");
        }
    }

    public void areStringEqual(String firstString, String secondString){
        if (firstString.equals(secondString)){
            System.out.println("The two strings are equal.");
        } else {
            System.out.println("The two strings are not equal.");
        }
    }

    /*
       3. Write a Java program that declares an integer variable age with a value of 20.
          Print a statement saying "I am adult" if age is 18 or more, else print "I am not an adult".
    */

    public void checkAge(){
        if (age >= 18){
            System.out.println("I am adult.");
        } else {
            System.out.println("I am not an adult.");
        }
    }

    /*
       4. Write a Java program where you declare two integer variables
          heightOne and heightTwo with any values.
          Use a ternary operator to determine the greater height and assign it to a variable maximumHeight.
          Print the result.
    */

    public int findMaximumHeight(){
        int maximumHeight = (heightOne > heightTwo) ? heightOne : heightTwo;
        return maximumHeight;
    }

    /*
       5. Write a Java program to print the numbers from 1 to 10 using a for loop.
          As a next step, modify your program to print only the even numbers from 1 to 10.
    */

    public void printNumbers(){
        for (int i = 1; i <= 10; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 2; i <= 10; i+=2){
            System.out.print(i + " ");
        }
    }
}
