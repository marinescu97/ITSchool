package main.java.session_3_java_operators;

public class PrePostIncrementDecrement {
    public static void main(String[] args) {
        //POST
        int x = 5;
        int y = x++;

        System.out.println("x = " + x); // 6
        System.out.println("y = " + y); // 5

        int z = 4;
        int w = z--;

        System.out.println("z = " + z); // 3
        System.out.println("w = " + w); // 4

        //PRE

        int a = 5;
        int b = ++a;

        System.out.println("x = " + a); // 6
        System.out.println("y = " + b); // 6
    }
}
