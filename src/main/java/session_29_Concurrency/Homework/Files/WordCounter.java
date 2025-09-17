package session_29_Concurrency.Homework.Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class WordCounter {
    public Map<String, Integer> countWords(List<Path> files, int numThreads) throws InterruptedException {
        ConcurrentMap<String, Integer> wordCount = new ConcurrentHashMap<>();
        ExecutorService executor = Executors.newFixedThreadPool(Math.max(1, numThreads));

        for (Path file : files) {
            executor.execute(() -> processFile(file, wordCount));
        }

        executor.shutdown();
        boolean finished = executor.awaitTermination(1, TimeUnit.HOURS);

        if (!finished) {
            System.err.println("Warning: Not all tasks finished within the timeout!");
        }

        return wordCount;
    }

    private void processFile(Path file, ConcurrentMap<String, Integer> wordCount) {
        try (Stream<String> lines = Files.lines(file)) {
            lines.forEach(line -> {
                for (String word : splitWords(line)) {
                    wordCount.merge(word, 1, Integer::sum);
                }
            });
        } catch (IOException e) {
            System.err.println("Error reading file: " + file + " - " + e.getMessage());
        }
    }

    private List<String> splitWords(String line) {
        return Arrays.stream(line.toLowerCase().split("\\W+"))
                .filter(word -> !word.isEmpty())
                .toList();
    }

    public void printTopWords(Map<String, Integer> wordCount, int topN) {
        wordCount.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(topN)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
