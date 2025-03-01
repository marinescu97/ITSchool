package main.java.session_3_java_operators;

public class Calculator {
    public static void main(String[] args) {
        int valA = 10;
        int valB = 5;
        int rez;
        char op = 'M'; // A S D M

        if (op == 'A'){
            rez = valA + valB;
        } else if (op == 'S') {
            rez = valA - valB;
        } else if (op == 'D') {
            rez = valA / valB;
        } else if (op == 'M') {
            rez = valA * valB;
        } else {
            rez = 0;
        }

        System.out.println("rez = " + rez);
    }
}
