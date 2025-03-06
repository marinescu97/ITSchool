package session_5_java_flow_control;

public class FlowControl {
    public static void main(String[] args) {
        printNumberWhileDo(5);
        System.out.println("-----------------");
        printNumberDoWhile(11);
        System.out.println("-----------------");
        printNumberFor(6);
        System.out.println("-----------------");
        printNumbersForEach(new int[]{1, 2, 3, 4, 5});
        System.out.println("-----------------");

        int[][] complexArray = {{4, 6, 5}, {1, 7, 3}, {3, 8, 5}};
        printListOfList(complexArray);

        System.out.println("-----------------");
        printNumbersUsingBreak(2, 5);
    }

    private static void printNumberWhileDo(int number){
        while (number <= 10){
            System.out.println("number is: " + number);
            number++;
        }
    }

    private static void printNumberDoWhile(int number){
        do {
            System.out.println("number is: " + number);
            number++;
        } while (number <= 10);
    }

    private static void printNumberFor(int number){
        for (int i = 0; i <= number; i++){
            System.out.println("number is: " + i);
        }
    }

    private static void printNumbersForEach(int[] array){
        for(int number : array){
            System.out.println("number is: " + number);
        }
    }

    private static void printListOfList(int[][] complexArray){
        for (int[] array : complexArray){
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

    private static void printNumbersUsingBreak(int number1, int number2){
        int i = 0;
        while (i <= 10){
            if (i == number1){
                i++;
                continue;
            }
            if (i == number2){
                break;
            }
            System.out.println("number is: " + i++);
        }
    }
}
