package session_4_operators_and_statements;

public class JavaStatements {
    public static void main(String[] args) {
        int currentYear = 2025;
        int birthYear = 1997;

        int diffYear = currentYear - birthYear;

        if (diffYear < 18){
            System.out.println("Sunt minor");
        } else if (diffYear > 70) {
            System.out.println("Opa the winter is coming");
        } else if (diffYear > 65) {
            System.out.println("am prins pensia");
        } else {
            System.out.println("Sunt doar major");
        }


    }
}
