package session_3_java_operators;

public class ArithmeticOperators {
    public static void main(String[] args) {
        int valA = 21;
        int valB = 6;
        int valC = 3;
        int valD = 1;

        int rez1 = valA - valB / valC;
        System.out.println("Rez1 = " + rez1);

        int rez2 = (valA - valB) / valC;
        System.out.println("Rez2 = " + rez2);

        int rez3 = valA / valC * valD + valB;
        System.out.println("Rez3 = " + rez3);

        int rez4 = valA / (valC * (valD + valB));
        System.out.println("Rez4 = " + rez4);


        int a = 2;
        int b = 3;
        int c = 4;

//        a += b; // a = a + b
//
//        a += b + 12; // a = a + (b + 12)
//
//        a += c * b - 5; // a = a * (c * b - 5)
//
//        System.out.println("a = " + a);

        // exemplu
        b *= a-- + ++c * 2; // b = 3 * (2 + 5 * 2) = 3 * 12
        System.out.println("b = " + b);


    }
}
