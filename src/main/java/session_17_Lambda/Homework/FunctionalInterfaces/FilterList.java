package session_17_Lambda.Homework.FunctionalInterfaces;

import java.util.List;

@FunctionalInterface
public interface FilterList {
    List<Integer> filter(List<Integer> list);
}
