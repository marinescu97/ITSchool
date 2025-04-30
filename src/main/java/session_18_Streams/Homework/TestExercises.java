package session_18_Streams.Homework;

public class TestExercises {
    public static void main(String[] args) {
        Exercises exercises = new Exercises();

        System.out.println("1 - Filter even numbers");
        exercises.filterEvenNumbers();

        System.out.println("2 - Print the longest string");
        exercises.getLongestString();

        System.out.println("3 - Print prime numbers from 1 to 100");
        exercises.getPrimeNumbers();

        System.out.println("4 - Concatenate strings");
        exercises.stringConcatenation();

        System.out.println("5 - Get people who are older than 18 years");
        exercises.getOlderPeople();

        System.out.println("6 - Get sum");
        exercises.getSum();

        System.out.println("7 - Strings to lengths");
        exercises.stringToLength();

        System.out.println("8 - Count vowels");
        exercises.countVowels();

        System.out.println("9 - Get the most frequently occurring word");
        exercises.findMostFrequent();

        System.out.println("10 - Get total number of characters");
        exercises.characterCounter();

        System.out.println("11 - Print the longest word from a file");
        exercises.printFromFile();

        System.out.println("12 - Get the department with the highest total salary");
        exercises.getMaxTotalSal();

        System.out.println("13 - Get product of strings");
        exercises.getProduct();

        System.out.println("14 - Get the category with the highest average price");
        exercises.getHighestAvgPrice();

        System.out.println("15 - Find books published before the year 2000");
        exercises.streamBooks();
    }
}
