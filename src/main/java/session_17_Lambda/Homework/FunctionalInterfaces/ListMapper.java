package session_17_Lambda.Homework.FunctionalInterfaces;

import java.util.List;
import java.util.function.Function;

@FunctionalInterface
public interface ListMapper {
    List<Integer> map(List<Integer> list, Function<Integer, Integer> function);
}
