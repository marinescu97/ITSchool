package session_1_java_basics;

public class MyFirstProject {
    public static void main(String[] args) {
        int age = 27;
        int secondaryAge = 3;

        System.out.println("Varsta mea este " + age);
        System.out.println(secondaryAge);

        int firstNumber;
        int secondNumber;

        firstNumber = 5;
        secondNumber = 2;

        int resultSum = firstNumber + secondNumber;
        System.out.println("Rezultatul adunarii este " + resultSum);

        int resultDiff = firstNumber - secondNumber;
        System.out.println("Rezultatul scaderii este " + resultDiff);

        int resultMult = firstNumber * secondNumber;
        System.out.println("Rezultatul inmultirii este " + resultMult);

        int resultDiv = firstNumber / secondNumber;
        System.out.println("Rezultatul impartirii este " + resultDiv);

        int resultMod = firstNumber % secondNumber;
        System.out.println("Rezultatul modulo este " + resultMod);

        String firstName = "Monica";
        String lastName = "Marinescu";

        String fullName = firstName + ' ' + lastName;

        System.out.println(fullName);

        double weight = 80.5d;
        System.out.println("Greutatea mea este " + weight);

        float weightFloat = 80.5f;
        System.out.println("Greutatea mea este " + weightFloat);

        long longNumber = 573859869302L;
        System.out.println(longNumber);
    }
}
