package session_17_Lambda.Homework.PDFResumeBuilder.PDFParser;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FileOpener {
    public static void openFile(File file) {
        if (file == null || !file.exists()) {
            System.out.println("File does not exist: " + file);
            return;
        }

        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                System.out.println("Failed to open file: " + e.getMessage());
            }
        } else {
            System.out.println("Desktop is not supported. Cannot open the file automatically.");
        }
    }
}
