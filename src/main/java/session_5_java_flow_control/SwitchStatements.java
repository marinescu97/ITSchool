package session_5_java_flow_control;

import java.util.Scanner;

public class SwitchStatements {

    public static final int MONDAY = 1;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;
    public static final int THURSDAY = 4;
    public static final int FRIDAY = 5;

    public static void main(String[] args) {
        printDayOfWeek();
        printDayOfWeekSimpleEdition();
        printGrade();
        printSeason();
    }

    private static void printDayOfWeek(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insert day of week from 1 to 5: ");
        int day = scanner.nextInt();

        switch (day){
            case MONDAY:
                System.out.println("today is Monday");
                break;
            case TUESDAY:
                System.out.println("today is Tuesday");
                break;
            case WEDNESDAY:
                System.out.println("today is Wednesday");
                break;
            case THURSDAY:
                System.out.println("today is Thursday");
                break;
            case FRIDAY:
                System.out.println("today is Friday");
                System.out.println("today is also Friday");
                break;
            default:
                System.out.println("Invalid day");
        }

    }

    public static void printDayOfWeekSimpleEdition(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insert day of week from 1 to 5: ");
        int day = scanner.nextInt();

        switch (day){
            case MONDAY -> System.out.println("Today is Monday");
            case TUESDAY -> System.out.println("Today is Tuesday");
            case WEDNESDAY -> System.out.println("Today is Wednesday");
            case THURSDAY -> System.out.println("Today is Thursday");
            case FRIDAY -> {
                System.out.println("Today is Friday");
                System.out.println("Today is also Friday");
            }
            default -> System.out.println("Invalid day");
        }
    }

    private static void printGrade(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please insert a grade (A, B, C, D); ");
        char grade = scanner.nextLine().toUpperCase().charAt(0);

        switch (grade){
            case 'A' -> System.out.println("Excelent");
            case 'B' -> System.out.println("Good");
            case 'C' -> System.out.println("Almost good");
            case 'D' -> System.out.println("Bad");
            default -> System.out.println("Invalid grade");
        }
    }

    private static void printSeason(){
        String season = "Winter";

        switch (season){
            case "Winter" -> System.out.println("It is cold");
            case "Spring" -> System.out.println("Flowers bloom");
            case "Summer" -> System.out.println("It is hot");
            case "Autumn" -> System.out.println("Leaves fell");
            default -> System.out.println("Invalid season");
        }
    }
}
