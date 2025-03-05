package session_4_operators_and_statements.Homework;

import java.util.ArrayList;
import java.util.List;

public class Exercises_6_10 {
    int temperature = 17;

    int sideOne = 5;
    int sideTwo = 5;
    int sideThree = 5;

    List<Integer> listOne = new ArrayList<>();
    List<Integer> listTwo = new ArrayList<>();

    /*
       6. Write a Java program where you declare an integer variable temperature.
          Assign a value to it and print "Hot" if the temperature is more than 30,
          "Warm" if the temperature is between 20 and 30, and "Cold" if it's less than 20.
    */

    public void checkTemperature(){
        String result = (temperature < 20) ? "Cold" : (temperature > 30) ? "Hot" : "Warm";
        System.out.println(result);
    }

    /*
       7. Write a Java program that determines the type of a triangle based on its sides.
          Declare three variables sideOne, sideTwo and sideThree to represent the sides of the triangle.
          Use the ternary operator to determine and print whether the triangle is
          "Equilateral", "Isosceles", or "Scalene".
    */

    public String typeOfTriangle(){
        return (sideOne == sideTwo && sideOne == sideThree) ? "Equilateral" :
                (sideOne == sideTwo || sideOne == sideThree) ? "Isosceles" : "Scalene";
    }

    /*
       8. Write a Java program to calculate the factorial of a number using a for loop.
          Declare an integer variable number and assign a value to it.
          Then calculate and print the factorial of number.
    */

    public long factorial(int number){
        int result = 1;

        for (int i = 1; i <= number; i++){
            result *= i;
        }

        return result;
    }

    /*
       9. Write a Java program to create two String variables, countryOne with the value "USA" and countryTwo
          with the value "USA".
          Check if countryOne and countryTwo are equal using the equals() method and print the result.
          Then change the value of countryTwo to "UK" and check for equality again.
          Print the result.
    */

    public void checkEquality(){
        String countryOne = "USA";
        String countryTwo = "USA";

        System.out.println(countryOne.equals(countryTwo));

        countryTwo = "UK";

        System.out.println(countryOne.equals(countryTwo));
    }

    /*
       10. Write a Java program that creates two distinct ArrayList objects, listOne and listTwo.
           Add some elements to listOne and assign listOne to listTwo.
           Now modify listOne by adding a new element.
           Print both lists and observe the output.
    */

    public void checkLists(){
        for (int i = 0; i < 5; i++){
            listOne.add(i);
        }

        listTwo = listOne;

        System.out.println("List one: " + listOne);
        System.out.println("List two: " + listTwo);

        System.out.println("----------------------");

        listOne.add(5);

        System.out.println("List one: " + listOne);
        System.out.println("List two: " + listTwo);
    }
}
