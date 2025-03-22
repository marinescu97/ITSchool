package session_8_Arrays.Homework;

import java.util.*;

public class Ex_1_9 {
    private final Scanner input = new Scanner(System.in);

    /*
        Create a shopping list with Array and print the values
    */

    public void shoppingList(){
        String[] list = {"Milk", "Bread", "Eggs", "Chocolate", "Apples", "Oranges", "Onions", "Carrots", "Potatoes"};

        for (String item : list){
            System.out.println(item);
        }
    }

    /*
        Create a wishlist for Christmas with ArrayList and print the values
    */

    public void wishList(){
        List<String> wishlist = new ArrayList<>(List.of("Books", "Phone", "Headphones", "Smartwatch", "Clothes"));

        for (String item : wishlist){
            System.out.println(item);
        }
    }

    /*
        Create
           - 2 empty ArrayLists: studentList and graduateStudentList
           - populate studentList with 10 students
           - copy values from studentList to graduateStudentList
           - iterate through graduateStudentList and print each graduated student
    */

    public void studentsList(){
        List<String> studentList = new ArrayList<>(List.of("Emma", "James", "David", "Alice", "Liam", "Sophia", "Mason", "Ethan", "Noah", "Isabella"));

        List<String> graduateStudentList = new ArrayList<>(studentList);

        for (String student : graduateStudentList){
            System.out.print(student + " ");
        }
    }

    /*
        Given an array of 10 integers, count how many of them are even numbers and how many are odd.
        Print out both counts.
    */

    public void evenOddNumbers(int[] numbers){
        int countEven = 0, countOdd = 0;

        for (int number : numbers){
            if (number % 2 == 0){
                countEven++;
            } else {
                countOdd++;
            }
        }

        System.out.printf("""
                Even numbers: %d
                Odd numbers: %d
                """, countEven, countOdd);
    }

    /*
        Create an ArrayList that stores city names. Add at least five city names initially.
        Then, prompt the user to add a city name.
        If the city name is already in the list, display a message saying it's a duplicate; otherwise, add it to the list.
    */

    public void addCity(){
        List<String> cities = new ArrayList<>(List.of("Constanta", "Bucuresti", "Timisoara", "Cluj", "Iasi", "Galati", "Tulcea"));

        System.out.print("Please insert a city: ");
        String city = input.nextLine();

        input.close();

        if (cities.contains(city)){
            System.out.println("The city name is already in the list.");
        } else {
            cities.add(city);
            System.out.println("The city name was added to the list -> " + cities);
        }
    }

    /*
        Given a LinkedList storing student names, write a program that checks if a particular student name exists in the list.
        If it does, remove that name from the list.
    */

    public void removeStudent(){
        List<String> studentList = new LinkedList<>(List.of("Emma", "James", "David", "Alice", "Liam", "Sophia", "Mason", "Ethan", "Noah", "Isabella"));

        System.out.print("Please insert a student name: ");
        String name = input.nextLine();

        input.close();

        if (studentList.contains(name)){
            studentList.remove(name);
            System.out.println("The name was removed from the list -> " + studentList);
        } else {
            System.out.println("The name is not in the list.");
        }
    }

    /*
        Create an ArrayList containing names of fruits.
        Implement a custom sorting mechanism to arrange them in descending order based on their length.
        If two fruits have the same length, sort them in alphabetical order.
    */

    public void sortFruits(){
        List<String> fruits = new ArrayList<>(List.of("Orange", "Apple", "Strawberry", "Grapes", "Banana", "Blueberries"));
        String temp;
        boolean flag = true;

        while (flag) {
            flag = false;
            for (int i = 0; i < fruits.size() - 1; i++) {

                if (fruits.get(i).length() < fruits.get(i + 1).length() ||
                        (fruits.get(i).length() == fruits.get(i + 1).length() && fruits.get(i).compareTo(fruits.get(i + 1)) < 0)) {
                    temp = fruits.get(i);
                    fruits.set(i, fruits.get(i + 1));
                    fruits.set(i + 1, temp);

                    flag = true;
                }
            }
        }
        System.out.println(fruits);
    }

    /*
        In an array of strings representing movie titles, implement a linear search method to find whether a given movie title exists.
        If it does, print out its position in the array.
    */

    public void findPosition(String title){
        String[] titles = {"Titanic", "Avatar", "Star Wars", "Jurassic Park", "Inception"};
        int index = -1;
        for (int i = 0; i < titles.length; i++){
            if (titles[i].equalsIgnoreCase(title)){
                index = i;
            }
        }

        if (index == -1){
            System.out.println("The title doesn't exist in the list.");
        } else {
            System.out.println("Position: " + index);
        }
    }

    /*
        Accept a string representation of a binary number, e.g., "1011".
        Convert this string into an Integer using the Integer wrapper class and the method that parses binary.
        Print out the decimal representation of this number.
    */

    public void binaryToNumber(String binary){
        System.out.println(Integer.parseInt(binary, 2));
    }
}
