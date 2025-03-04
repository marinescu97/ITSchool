package session_3_java_operators;

public class CastExamples {
    public static void main(String[] args) {
        byte byteVal = 6;
        short shortVal = 2;
        int intVal = 10;
        float floatVal = 1.0f;
        double doubleVal = 2.0d;
        long longVal = 1235435612L;

        shortVal = byteVal;

        System.out.println("Short value : " + shortVal);

        float rezultat = floatVal - longVal;
        System.out.println("Valoare rezultat: " + rezultat);

        floatVal = longVal;
        System.out.println("Float value : " + floatVal);

        intVal = Integer.MIN_VALUE;
        System.out.println("Valoare minima int: " + intVal);

        intVal = Integer.MAX_VALUE;
        System.out.println("Valoare maxima int: " + intVal);

        longVal = Long.MIN_VALUE;
        System.out.println("Valoare minima long: " + longVal);

        longVal = Long.MAX_VALUE;
        System.out.println("Valoare maxima long: " + longVal);

        System.out.println("Valoare minima float: " + Float.MIN_VALUE);
        System.out.println("Valoare maxima float: " + Float.MAX_VALUE);

        System.out.println("Valoare minima double: " + Double.MIN_VALUE);
        System.out.println("Valoare maxima double: " + Double.MAX_VALUE);

        int intNumber = (int) 4.9f;
        System.out.println("Valoare intNumber: " + intNumber);
    }
}
