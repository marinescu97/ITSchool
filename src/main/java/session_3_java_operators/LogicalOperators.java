package main.java.session_3_java_operators;

public class LogicalOperators {
    public static void main(String[] args) {
        boolean isPresent = true;
        boolean isRegistered = false;

        System.out.println("Is present: " + isPresent);
        System.out.println("Is registered: " + isRegistered);

        System.out.println("!Is present: " + !isPresent);
        System.out.println("!Is registered " + !isRegistered);

        int valA = 3;
        int valB = 3;

        if (valA > valB){
            System.out.println("valA este mai mare");
        } else if (valA < valB){
            System.out.println("valA este mai mic");
        } else {
            System.out.println("valorile sunt egale");
        }

//        int a = (3 < 5) ? 4 : 6;
//        System.out.println("a = " + a);

        int a = 10, b = 20;
        System.out.println((a == b));
        System.out.println((a < b));
        System.out.println((a > b));
        System.out.println((a >= b));
        System.out.println((a <= b));
    }
}
