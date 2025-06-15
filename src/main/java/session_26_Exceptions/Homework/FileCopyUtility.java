package session_26_Exceptions.Homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileCopyUtility {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the source file path: ");
            String source = scanner.nextLine();

            System.out.print("Enter the destination file path: ");
            String destination = scanner.nextLine();

            copyFile(source, destination);
        }
    }

    private static void copyFile(String sourcePath, String destinationPath){
        try (
                FileInputStream in = new FileInputStream(sourcePath);
                FileOutputStream out = new FileOutputStream(destinationPath)
        ) {
            int n;

            while ((n = in.read()) != -1) {
                out.write(n);
            }
            System.out.println("File Copied");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Source file not found - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: An I/O error occurred - " + e.getMessage());
        }
    }
}
