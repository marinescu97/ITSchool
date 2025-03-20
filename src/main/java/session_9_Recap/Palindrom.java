package session_9_Recap;

public class Palindrom {
    public static void main(String[] args) {
        String word = "radar";

        System.out.println(isPalindrom(word));
    }

    public static boolean isPalindrom(String word){
        int stanga = 0;
        int dreapta = word.length()-1;

        while (stanga < dreapta){
            if (word.charAt(stanga) != word.charAt(dreapta)){
                return false;
            } else {
                stanga++;
                dreapta--;
            }
        }

        return true;
    }


}
