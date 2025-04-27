package session_17_Lambda.Homework.FunctionalInterfaces;

import java.util.List;

@FunctionalInterface
public interface ElementFinder <T> {
    boolean exist(List<T> list, T element);
}
