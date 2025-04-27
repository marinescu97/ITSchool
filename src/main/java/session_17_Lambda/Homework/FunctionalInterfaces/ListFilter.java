package session_17_Lambda.Homework.FunctionalInterfaces;

import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
public interface ListFilter<T> {
    List<T> filter(List<T> list, Predicate<T> predicate);
}
