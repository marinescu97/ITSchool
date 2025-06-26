package JavaBase;

import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface Calculator{
    int compute(int a, int b);
}
public class FunctionalDemo {
    public static void main(String[] args) {
        // (parametri) -> expresie
        // (p1, p2) -> {bloc de executie}

        List<String> list = List.of("Marcel", "Vio");
        list.forEach(n -> System.out.println(n));
        list.forEach(System.out::println);

        List<Integer> numbers = List.of(1, 2, 3, 5, 4, 7, 2, 3);
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(distinctNumbers);
    }

}
