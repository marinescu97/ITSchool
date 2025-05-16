package session_18_Streams.Homework.ExpenseTracker;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputReader {
    public static double readAmount(Scanner scanner, String inputMsg, boolean acceptEmpty){
        while (true){
            System.out.print(inputMsg);

            String input = scanner.nextLine();

            if (acceptEmpty && input.isEmpty()) {
                return -1;
            }

            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    public static LocalDate readDate(Scanner scanner, String inputMsg, boolean acceptEmpty) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while (true) {
            System.out.print(inputMsg);
            String input = scanner.nextLine();

            if (acceptEmpty && input.isEmpty()) {
                return null;
            }

            try {
                return LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }
    }

    public static int readChoice(Scanner scanner, String inputMsg){
        while (true){
            System.out.print(inputMsg);

            if (scanner.hasNextInt()){
                return scanner.nextInt();
            } else {
                System.out.println("Invalid input. Try again.");
                scanner.nextLine();
            }
        }
    }

    public static char readYesOrNo(Scanner scanner, String inputMsg) {
        while (true) {
            System.out.print(inputMsg);
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.length() == 1 && (input.charAt(0) == 'y' || input.charAt(0) == 'n')) {
                return input.charAt(0);
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        }
    }

    public static String readFilePath(Scanner scanner, String inputMsg) {
        while (true) {
            System.out.print(inputMsg);
            String filePath = scanner.nextLine().trim();

            if (!filePath.endsWith(".txt")) {
                System.out.println("Invalid file path. The file must have a .txt extension.");
                continue;
            }

            if (isValidFilePath(filePath)) {
                return filePath;
            } else {
                System.out.println("Invalid path. The file could not be created or accessed.");
            }
        }
    }

    public static boolean isValidFilePath(String filePath) {
        try {
            Path path = Paths.get(filePath);
            File file = path.toFile();

            if (file.exists()) {
                return true;
            } else {
                File parentDir = file.getParentFile();
                return parentDir != null && parentDir.exists();
            }
        } catch (Exception e) {
            return false;
        }
    }
}
