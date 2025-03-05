package session_4_operators_and_statements;

public class ForStatements {
    public static void main(String[] args) {
        for (int i = 0; i < 11; i++){
            System.out.println(" valoarea lui i este: " + i);
        }

        for (int i = 0; i < 11; i+=2){
            System.out.println(" valoarea para a lui i este: " + i);
        }

        int[] array = {1, 2, 3, 4, 5};

        for (int number : array){
            System.out.println("numarul din lista este: " + number);
        }
    }
}
