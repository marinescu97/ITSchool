package session_6_core_api.Homework;

public class IntegerToRoman {
    public static String integerToRoman(int number){
        if (number < 1 || number > 3999){
            return "Invalid number";
        }

        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return M[number/1000] + C[(number%1000)/100] + X[(number%100)/10] + I[number%10];
    }
}
