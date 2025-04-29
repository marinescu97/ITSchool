package session_18_Streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamDemo {
    public static void main(String[] args) {
        System.out.print("1 -> Filter + ForEach: ");
        demoFilterForEach();

        System.out.print("2 -> Map + Collect: ");
        demoMapCollect();

        System.out.print("3 -> Distinct + Sorted + Collect: ");
        demoDistinctSorted();

        System.out.print("4 -> FlatMap + Collect: ");
        demoFlatMap();

        System.out.print("5 -> Reduce: ");
        demoReduce();

        System.out.print("6 -> Count: ");
        demoCount();

        System.out.print("7 -> AnyMatch: ");
        demoAny();

        System.out.print("8 -> Method Reference: ");
        demoMR();

        System.out.print("9 -> Optional: ");
        demoOptional();

        System.out.println("10 -> Demo complex: ");
        demoComplex();

        System.out.println("11 -> Person grouped by age ");
        demoGroupByAge();

        System.out.println("12 -> Person partitioned by age");
        demoPartitioningBy();
    }

    private static void demoFilterForEach(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.stream()
                .filter(n -> n % 2 == 0)
//                .forEach(System.out::print);
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    private static void demoMapCollect(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String> asStrings = numbers.stream()
                .map(n -> "Nr: " + n)
                .collect(Collectors.toList());
        System.out.println(asStrings);
    }

    private static void demoDistinctSorted(){
        List<Integer> numbers = List.of(1, 3, 2, 6, 9, 1);
        List<Integer> distinctSorted = numbers.stream()
                .distinct()
//                .sorted()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(distinctSorted);
    }

    private static void demoFlatMap(){
        List<List<String>> listOfList = List.of(
                List.of("a", "b"),
                List.of("c"),
                List.of("d", "e")
        );

        List<String> listOfStrings = listOfList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(listOfStrings);
    }

    private static void demoReduce(){
        List<Integer> numbers = List.of(1, 2, 3, 4);
        int multy = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println(multy);
    }

    private static void demoCount(){
        List<String> listOfStrings = List.of("Ana", "Dan", "Marcel");
        long count = listOfStrings.stream()
                .filter(s -> s.length() == 3)
                .count();
        System.out.println(count);
    }

    private static void demoAny(){
        List<String> listOfStrings = List.of("Ana", "Dan", "Marcel");
        boolean hasAny = listOfStrings.stream()
                .anyMatch(s -> s.length() == 6);
        System.out.println(hasAny);
    }

    private static void demoMR(){
        List<String> listOfStrings = List.of("Ana", "Dan", "Marcel");
        listOfStrings.stream()
                .map(String::toUpperCase)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

    private static void demoOptional(){
        Optional<Integer> listOptional = IntStream.rangeClosed(1, 10)
                .filter(n -> n % 2 == 0)
                .boxed()
                .findFirst();
        System.out.println(listOptional);
    }

    private static void demoComplex(){
        List<Employee> employees = List.of(
                new Employee("Ana", "IT", 5000),
                new Employee("Dan", "HR", 4500),
                new Employee("Marcel", "IT", 6000)
        );

        Map<String, Double> avgSalDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
        avgSalDepartment.forEach(
                (dep, sal) -> System.out.println("dep: " + dep + " -> sal: " + sal)
        );
    }

    private static void demoGroupByAge() {
        List<Person> people = List.of(
                new Person("Ana", 22),
                new Person("Ion", 30),
                new Person("Maria", 22),
                new Person("George", 30)
        );

        Map<Integer, List<Person>> byAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        byAge.forEach((age, list) -> {
            System.out.println("Age " + age + ": " +
                    list.stream()
                            .map(Person::getName)
                            .collect(Collectors.joining(", "))
            );
        });
    }

    private static void demoPartitioningBy(){
        List<Person> people = List.of(
                new Person("Ana", 22),
                new Person("Ion", 30),
                new Person("Maria", 20),
                new Person("George", 27)
        );

        Map<Boolean, List<Person>> partitioned = people.stream()
                .collect(Collectors.partitioningBy(p -> p.getAge() < 25));

        System.out.println("Tineri (<25): " +
                partitioned.get(true).stream().map(Person::getName).toList());

        System.out.println("Maturi (>=25): " +
                partitioned.get(false).stream().map(Person::getName).toList());
    }

    static class Employee{
        private final String name;
        private final String department;
        private final int salary;

        public Employee(String name, String department, int salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public int getSalary() {
            return salary;
        }
    }

    static class Person{
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
