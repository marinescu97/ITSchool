package session_6_core_api.Homework;

import java.util.Scanner;

public class Beginner {
    private final Scanner input = new Scanner(System.in);

    /*
        Reverse a String
        Write a program to reverse an input string using StringBuilder.
     */

    public String reverseString(String str){
        System.out.print("Please insert a text: ");
        StringBuilder text = new StringBuilder(input.nextLine());

        return String.format("The reversed text is: %s", text.reverse());
    }

    /*
        Palindrome Checker
        Check if a string is a palindrome using StringBuilder.
     */

    public boolean isPalindrome(String str){
        StringBuilder result = new StringBuilder(str);
        return result.reverse().toString().trim().equals(str.trim());
    }

    /*
        Concatenate Multiple Strings
        Efficiently concatenate multiple strings into one using StringBuilder.
     */

    public String concatenateStrings(String... str){
        StringBuilder result = new StringBuilder();

        for (String s : str){
            result.append(s).append(", ");
        }

        return result.delete(result.length()-2, result.length()).toString();
    }

    /*
        Removing Vowels
        Remove all vowels from a string using StringBuilder.
     */

    public String removeVowels(String str){
        StringBuilder result = new StringBuilder();
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < str.length(); i++){
            char current = str.charAt(i);

            if (vowels.indexOf(current) == -1){
                result.append(current);
            }
        }

        return result.toString();
    }

    /*
        Word Capitalizer
        Capitalize the first letter of every word in a sentence using StringBuilder.
     */

    public String wordCapitalizer(String sentence){
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words){
            result.append(word.toUpperCase().charAt(0))
                    .append(word.substring(1))
                    .append(" ");
        }

        return result.toString().trim();
    }












}
