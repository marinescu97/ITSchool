package session_13_OOP_4.Homework.Examples;

public class MathOperations {
    public static void main(String[] args) {
        System.out.println(sum(1, 4));
        System.out.println(sum(5.0, 3.5));
        System.out.println(sum(1, 4, 8));

        double doubleValue = 1.9;
        int intValue = (int) doubleValue;
        System.out.println(intValue);
    }

    public static int sum(int a, int b){
        return a + b;
    }

    public static double sum(double a, double b){
        return a + b;
    }

    public static int sum(int a, int b, int c){
        return a + b + c;
    }
}
