package session_18_Streams.Homework.ExpenseTracker;

import java.time.LocalDate;
import java.util.Scanner;

@FunctionalInterface
public interface Validator<T> {
    T validate();

    static Validator<Double> getAmount(Scanner scanner, String inputMsg, boolean acceptEmpty){
        return () -> InputReader.readAmount(scanner, inputMsg, acceptEmpty);
    }

    static Validator<LocalDate> getDate(Scanner scanner, String inputMsg, boolean acceptEmpty) {
        return () -> InputReader.readDate(scanner, inputMsg, acceptEmpty);
    }

    static Validator<Integer> getChoice(Scanner scanner, String inputMsg){
        return () -> InputReader.readChoice(scanner, inputMsg);
    }

    static Validator<Character> getYesOrNo(Scanner scanner, String inputMsg) {
        return () -> InputReader.readYesOrNo(scanner, inputMsg);
    }

    static Validator<String> getFilePath(Scanner scanner, String inputMsg) {
        return () -> InputReader.readFilePath(scanner, inputMsg);
    }
}
