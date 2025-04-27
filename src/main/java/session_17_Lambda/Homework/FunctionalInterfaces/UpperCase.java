package session_17_Lambda.Homework.FunctionalInterfaces;

import java.util.List;

@FunctionalInterface
public interface UpperCase {
    List<String> apply(List<String> list);
}
