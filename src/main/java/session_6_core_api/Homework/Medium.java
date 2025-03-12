package session_6_core_api.Homework;

import java.util.LinkedHashMap;
import java.util.Map;

public class Medium {
    /*
        String Replacement
        Replace all occurrences of a substring in a string using StringBuilder.
    */

    public String stringReplacement(String textToTransform, String textToReplace, String replacementText){
        StringBuilder result = new StringBuilder(textToTransform);

        int index = result.indexOf(textToReplace);

        while (index != -1){
            result.replace(index, index + textToReplace.length(), replacementText);
            index = result.indexOf(textToReplace);
        }

        return result.toString();
    }

    /*
        Duplicate Character Remover
        Remove duplicate characters from a string using StringBuilder.
    */

    public String duplicateCharacterRemover(String text){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++){
            if (result.indexOf(String.valueOf(text.charAt(i))) == -1){
                result.append(text.charAt(i));
            }
        }

        return result.toString();
    }

    /*
        Inserting at Index
        Insert a string at a specified index in another string using StringBuilder.
    */

    public String insertText(String text, String textToInsert, int index){
        StringBuilder result = new StringBuilder(text);

        return result.insert(index, textToInsert).toString();
    }

    /*
        Frequency Counter
        Count the frequency of each character in a string using StringBuilder.
    */

    public void frequencyCounter(String text){
        StringBuilder sbText = new StringBuilder(text);
        Map<Character, Integer> characters = new LinkedHashMap<>();
        char currentCharacter;

        for (int i = 0; i < sbText.length(); i++){
            currentCharacter = sbText.charAt(i);
            if (!characters.containsKey(currentCharacter)){
                characters.put(currentCharacter, 1);
            } else {
                int value = characters.get(currentCharacter) + 1;
                characters.replace(currentCharacter, value);
            }
        }

        for (Character key : characters.keySet()){
            System.out.println(key + ": " + characters.get(key));
        }
    }

    /*
        Morse Code Converter
        Convert a string to Morse code using StringBuilder.
    */

    public String morseCodeConverter(String text){
        char[] letters =
                { 'a', 'b', 'c', 'd', 'e', 'f',
                'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x',
                'y', 'z'};

        String[] code =
                { ".-",   "-...", "-.-.", "-..",  ".",
                "..-.", "--.",  "....", "..",   ".---",
                "-.-",  ".-..", "--",   "-.",   "---",
                ".--.", "--.-", ".-.",  "...",  "-",
                "..-",  "...-", ".--",  "-..-", "-.--",
                "--.."};
        StringBuilder result = new StringBuilder(text.toLowerCase());

        for (int i = 0; i < letters.length; i++){
            int index = result.indexOf(String.valueOf(letters[i]));
            if (index > -1){
                result.replace(index, index+1, code[i] + " ");
            }
        }
        return result.toString().trim();
    }
}
