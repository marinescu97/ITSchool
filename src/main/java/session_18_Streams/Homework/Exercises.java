package session_18_Streams.Homework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercises {

    public void filterEvenNumbers(){
        List<Integer> numbers = Arrays.asList(3, 4, 7, 8, 12, 15);

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        System.out.println(evenNumbers + "\n");
    }

    public void getLongestString(){
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        String result = strings.stream()
                .max(Comparator.comparing(String::length))
                .get();
        System.out.println(result + "\n");
    }

    public void getPrimeNumbers(){
        List<Integer> primeNumbers = IntStream.rangeClosed(1, 100)
                .filter(this::isPrime)
                .boxed()
                .toList();
        System.out.println(primeNumbers + "\n");
    }

    private boolean isPrime(int number){
        if (number < 2) return false;
        return IntStream.rangeClosed(2, (int)Math.sqrt(number))
                .allMatch(i -> number % i != 0);
    }

    public void stringConcatenation(){
        List<String> strings = Arrays.asList("one", "two", "three", "four");

        String result = strings.stream()
                .collect(Collectors.joining(", "));
        System.out.println(result + "\n");
    }

    public void getOlderPeople(){
        List<Person> people = Arrays.asList(
                new Person("Alice", "Johnson", 20),
                new Person("Bob", "Smith", 17),
                new Person("John", "Doe", 21));

        List<Person> result = people.stream()
                .filter(person -> person.age() > 18)
                .toList();
        System.out.println(result + "\n");
    }

    public void getSum(){
        Integer[] numbers = {1, 2, 3, 4, 5};

        int sum = Arrays.stream(numbers)
                .reduce(0, Integer::sum);
        System.out.println(sum + "\n");
    }

    public void stringToLength(){
        List<String> strings = Arrays.asList("Hello", "World", "Java", "Streams");

        List<Integer> result = strings.stream()
                .map(String::length)
                .toList();
        System.out.println(result + "\n");
    }

    public void countVowels(){
        String sentence = "Hello World";
        long count = sentence.chars()
                .filter(c -> "aeiou".indexOf(c) >= 0)
                .count();
        System.out.println(count + "\n");
    }

    public void findMostFrequent(){
        List<String> sentences = Arrays.asList("Hello World", "Hello Everyone", "Welcome to the World of Java");

        sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry ->
                        System.out.println(entry.getKey() + " -> " + entry.getValue()));
        System.out.println();
    }

    public void characterCounter(){
        List<String> strings = Arrays.asList("Java Streams", "Method References", "Lambda Expressions");

        int sum = strings.stream()
                .flatMapToInt(String::chars)
                .filter(c -> !Character.isWhitespace(c))
                .map(c -> 1)
                .sum();
        System.out.println(sum + "\n");
    }

    public void printFromFile(){
        Path path = Path.of("Files/Homework_session_18/StreamFile.txt");

        try(Stream<String> lines = Files.lines(path)) {
            lines
                .filter(line -> !line.trim().isEmpty())
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .max(Comparator.comparingInt(String::length))
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("No word found.")
                );
            System.out.println();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public void getMaxTotalSal(){
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 5500),
                new Employee("Maria", "Marketing", 5000),
                new Employee("Dan", "HR", 4700),
                new Employee("Ioana", "IT", 6000),
                new Employee("Marian", "Finance", 6200),
                new Employee("John", "Engineering", 7000)
        );

        employees.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.summingDouble(Employee::salary)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
        System.out.println();
    }

    public void getProduct(){
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5");
        int product = numbers.stream()
                .map(Integer::valueOf)
                .reduce(1, (a, b) -> a * b);
        System.out.println(product + "\n");
    }

    public void getHighestAvgPrice(){
        List<Product> products = List.of(
                new Product("Laptop", "Electronics", 1200.00),
                new Product("Smartphone", "Electronics", 799.99),
                new Product("Desk Chair", "Furniture", 150.00),
                new Product("Notebook", "Stationery", 2.99),
                new Product("Pen Set", "Stationery", 5.49),
                new Product("Coffee Table", "Furniture", 249.00)
        );

        String result = products.stream()
                .collect(Collectors.groupingBy(Product::category, Collectors.averagingDouble(Product::price)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(entry -> entry.getKey() + " -> " + entry.getValue())
                .orElse("No category found.");
        System.out.println(result + "\n");
    }

    public void streamBooks(){
        List<Book> books = List.of(
                new Book("To Kill a Mockingbird", "Harper Lee", 1960),
                new Book("1984", "George Orwell", 1949),
                new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925),
                new Book("The Night Circus", "Erin Morgenstern", 2011),
                new Book("The Catcher in the Rye", "J.D. Salinger", 1951),
                new Book("The Lost Symbol", "Dan Brown", 2009),
                new Book("Pride and Prejudice", "Jane Austen", 1813),
                new Book("The Road", "Cormac McCarthy", 2006),
                new Book("Origin", "Dan Brown", 2017),
                new Book("The Da Vinci Code", "Dan Brown", 2003)
        );
        books.stream()
                .filter(book -> book.publicationYear() > 2000)
                .collect(Collectors.groupingBy(Book::author, Collectors.mapping(Book::title, Collectors.toList())))
                .forEach((author, titles) -> System.out.println(author + " -> " + String.join(", ", titles)));
    }
}

record Person(String firstName, String lastName, int age) {
    @Override
    public String toString() {
        return String.format("%s %s -> %d", firstName, lastName, age);
    }
}
record Employee(String name, String department, double salary) {}
record Product(String name, String category, double price) {}
record Book(String title, String author, int publicationYear) {}
