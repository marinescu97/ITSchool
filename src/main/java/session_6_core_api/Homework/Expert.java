package session_6_core_api.Homework;

import java.util.Arrays;

public class Expert {
    /*
        Encode and Decode using Caesar Cipher
        Implement a Caesar Cipher encoder and decoder using StringBuilder.
    */

    public String caesarCipherEncoder(String text, int shift){
        StringBuilder result = new StringBuilder();
        char currentCharacter, encodedCharacter;

        for (int i = 0; i < text.length(); i++){
            currentCharacter = text.charAt(i);
            if (Character.isUpperCase(currentCharacter)){
                encodedCharacter = (char) (((int) currentCharacter + shift - 65) % 26 + 65);
            } else if (Character.isLowerCase(currentCharacter)){
                encodedCharacter = (char) ((currentCharacter + shift - 97) % 26 + 97);
            } else {
                encodedCharacter = currentCharacter;
            }
            result.append(encodedCharacter);
        }

        return result.toString();
    }

    public String caesarCipherDecoder(String text, int shift){
        return caesarCipherEncoder(text, 26-shift);
    }

    /*
        CamelCase to Snake_case Converter
        Convert a CamelCase string to snake_case using StringBuilder.
    */

    public String camelCaseToSnakeCase(String text){
        StringBuilder result = new StringBuilder();
        char currentCharacter;

        for (int i = 0; i < text.length(); i++){
            currentCharacter = text.charAt(i);

            if (Character.isUpperCase(currentCharacter)){
                if (i > 0){
                    result.append("_");
                }
                result.append(Character.toLowerCase(currentCharacter));
            } else {
                result.append(currentCharacter);
            }
        }

        return result.toString();
    }

    /*
        Expand Compressed Strings
        Expand a compressed string (e.g., "a3b2c4" -> "aaabbcccc") using StringBuilder.
    */

    public String expandCompressedString(String text){
        StringBuilder result = new StringBuilder();
        char currentCharacter;

        for (int i = 0; i < text.length(); i++){
            currentCharacter = text.charAt(i);

            if (Character.isDigit(currentCharacter)){
                int digit = currentCharacter - '0';
                result.append(String.valueOf(text.charAt(i - 1)).repeat(Math.max(0, digit)));
            }
        }
        return result.toString();
    }

    /*
        Remove Comments from Code
        Remove single line (//) and multi-line (/* */ /*) comments from code using StringBuilder.
     */

    public String removeCommentsFromCode(String code){
        StringBuilder result = new StringBuilder();
        String[] lines = code.split("\n");

        for (String line : lines){
            if (!line.contains("//") && !line.contains("/*") && !line.contains("*/")){
                result.append(line).append("\n");
            } else if ((line.contains("//") || line.contains("/*")) && line.charAt(0) != '/'){
                result.append(line, 0, line.indexOf('/')).append("\n");
            } else if (line.contains("*/")) {
                result.append("\t").append(line.substring(line.indexOf('/') + 1)).append("\n");
            }
        }

        return result.toString();
    }



    /*
        Anagram Checker
        Check if two strings are anagrams using StringBuilder.
    */

    public String anagramChecker(String firstString, String secondString){
        char[] firstStringArr = firstString.toLowerCase().toCharArray();
        char[] secondStringArr = secondString.toLowerCase().toCharArray();

        Arrays.sort(firstStringArr);
        Arrays.sort(secondStringArr);

        if (Arrays.toString(firstStringArr).equals(Arrays.toString(secondStringArr)) && firstString.length() == secondString.length()){
            return "The two strings are anagrams";
        }

        return "The two strings are not anagrams";
    }

    /*
        Toggling Case
        Toggle the case of every character in a string using StringBuilder.
     */

    public String caseToggler(String text){
        StringBuilder result = new StringBuilder(text);
        char currentChar;

        for (int i = 0; i < result.length(); i++){
            currentChar = result.charAt(i);
            if (Character.isUpperCase(currentChar)){
                result.setCharAt(i, Character.toLowerCase(currentChar));
            } else {
                result.setCharAt(i, Character.toUpperCase(currentChar));
            }
        }

        return result.toString();
    }
}
