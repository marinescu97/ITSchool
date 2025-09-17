package session_29_Concurrency.Homework.Files;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

// This program demonstrates both single-threaded and multithreaded word counting across multiple text files.
public class Main {
    private static final String BASE_PATH = "Files/Homework_session_29/";

    public static void main(String[] args) throws IOException, InterruptedException {
        List<Path> files = List.of(
                Paths.get(BASE_PATH + "file1.txt"),
                Paths.get(BASE_PATH + "file2.txt"),
                Paths.get(BASE_PATH + "file3.txt"),
                Paths.get(BASE_PATH + "file4.txt"),
                Paths.get(BASE_PATH + "file5.txt")
        );

        WordCounter counter = new WordCounter();

        // Single-threaded
        long startSingle = System.currentTimeMillis();
        Map<String, Integer> singleResult = counter.countWords(files, 1);
        long endSingle = System.currentTimeMillis();
        System.out.println("Single-threaded time: " + (endSingle - startSingle) + " ms");

        System.out.println("\nTop 10 words (singlethreaded):");
        counter.printTopWords(singleResult, 10);

        System.out.println();

        // Multithreaded
        long startMulti = System.currentTimeMillis();
        Map<String, Integer> multiResult = counter.countWords(files, 5); // 3 threads
        long endMulti = System.currentTimeMillis();
        System.out.println("Multithreaded time: " + (endMulti - startMulti) + " ms");

        System.out.println("\nTop 10 words (multithreaded):");
        counter.printTopWords(multiResult, 10);
    }
}
