package JavaBase;

public class Statements {
    public static void main(String[] args) {
        int x = 10;

        if (x > 0){
            System.out.println("x este pozitiv");
        } else if (x < 0) {
            System.out.println("x este negativ");
        } else {
            System.out.println("x este egal cu 0");
        }

        String day = "monday";

        switch (day){
            case "monday" -> System.out.println("It's Monday");
            case "friday" -> System.out.println("It's friday");
            default -> System.out.println("It's another day.");
        }

        for (int i = 0; i <= 10; i++){
            System.out.println(i);
        }

        int j = 10;
        while (j > 2){
            System.out.println("j = " + j);
            j--;
        }

        String[] arr = {"a", "b", "c"};

        for (String s : arr){
            System.out.println(s);
        }
    }
}
