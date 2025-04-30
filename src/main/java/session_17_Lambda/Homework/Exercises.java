package session_17_Lambda.Homework;

import session_17_Lambda.Homework.FunctionalInterfaces.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exercises {
        /*
            Write a program that uses lambda expressions to filter a list of integers and return only the even numbers.
        */

        public static List<Integer> filterEvenNumbers(List<Integer> list){
            Predicate<Integer> isEven = number -> number % 2 == 0;
            List<Integer> result = new ArrayList<>(list);
            result.removeIf(isEven.negate());

            return result;
        }

        /*
            Write a program that uses lambda expressions to sort a list of strings in alphabetical order.
        */

        public static void sort(List<String> list){
            list.sort((a, b) -> a.compareTo(b));
            System.out.println("Sorted list: " + list);
        }

        /*
            Write a program that uses lambda expressions to calculate the sum of all the elements in a list of integers.
        */

        public static int listSum(List<Integer> list){
            int result = 0;
            BinaryOperator<Integer> sum = (a, b) -> a + b;

            for (int number : list){
                result = sum.apply(result, number);
            }

            return result;
        }

        /*
            You are given a List<String> representing a list of words.
            Create a lambda expression to sort the list in alphabetical order.
            Next, modify your lambda expression to sort the list in reverse alphabetical order.
         */

        public static void sortList(List<String> list){
            Comparator<String> comparator = (a, b) -> a.compareTo(b);
            list.sort(comparator);
            System.out.println("Alphabetical order: " + list);

//            comparator = (a, b) -> b.compareTo(a);
            list.sort(comparator.reversed());
            System.out.println("Reverse alphabetical order: " + list);
        }

        /*
            Create a functional interface that takes a list of integers and returns the maximum value from the list.
            Implement this interface using a lambda expression.
            Ensure your lambda correctly handles an empty list case.
        */

            public static int getMaxValue(List<Integer> list){
                MaxValue maxValue = numbers -> (numbers == null || numbers.isEmpty()) ? null : Collections.max(numbers);

                return maxValue.get(list);
            }

        /*
            Create a functional interface with a method that takes two strings as input and returns an integer.
            Implement this interface using a lambda expression to create a custom comparator that compares strings based on their length (not lexicographically).
        */

            public static int compareLengths(String first, String second){
                LengthComparator lengthComparator = (a, b) -> Integer.compare(a.length(), b.length());
                return lengthComparator.compare(first, second);
            }

        /*
            Create a functional interface that takes a string and an integer n as parameters and returns a string.
            Implement it using a lambda expression that returns the first n characters of the string.
            If n is larger than the length of the string, it should return the full string.
        */

            public static String findSubstring(String word, int nunmber){
                Substring substring = (s, n) -> n >= s.length() ? s : s.substring(0, n);
                return substring.get(word, nunmber);
            }

        /*
            Create a functional interface that takes a List<Integer> and a function that takes an integer as input and returns an integer.
            Implement this interface using a lambda expression to apply the function to each element in the list, returning a new list with the mapped values.
        */

        public static List<Integer> map(List<Integer> list, Function<Integer, Integer> function){
            ListMapper mapper = (elements, func) -> applyFunction(elements, func);

            return mapper.map(list, function);
        }

        private static List<Integer> applyFunction(List<Integer> list, Function<Integer, Integer> function){
            List<Integer> result = new ArrayList<>();
            list.forEach(element -> result.add(function.apply(element)));
            return result;
        }

        /*
            Create a functional interface that takes a list of integers and returns a list of integers.
            Use a lambda expression to implement this interface, such that it returns a list containing only the odd numbers from the original list.
        */

            public static List<Integer> filterList(List<Integer> list){
                FilterList filterList = elements -> addOddElements(elements);

                return filterList.filter(list);
            }

            private static List<Integer> addOddElements(List<Integer> list){
                List<Integer> result = new ArrayList<>();
                list.forEach(element -> {
                    if (element % 2 != 0){
                        result.add(element);
                    }
                });
                return result;
            }

        /*
            Create a functional interface with a method that takes a List<String> representing first names and returns a List<String>
            of those names formatted in uppercase.
            Implement it using a lambda expression.
        */

            public static List<String> transformNames(List<String> names){
                UpperCase upperCase = list -> toUpperCase(list);

                return upperCase.apply(names);
            }

            private static List<String> toUpperCase(List<String> list){
                List<String> result = new ArrayList<>();
                for (String s : list) {
                    result.add(s.toUpperCase());
                }

                return result;
            }

        /*
            Create a functional interface that is generic and takes a list of generic items and a single generic item,
            returning a boolean indicating whether the item is in the list.
            Implement this interface using a lambda expression.
        */

            public static <T> boolean contains(List<T> list, T element){
                ElementFinder<T> elementFinder = (lst, elem) -> lst.contains(elem);
                return elementFinder.exist(list, element);
            }

        /*
            Create a functional interface with a method that takes two strings and returns a string.
            Implement this interface using a lambda expression to create a utility that joins two strings with a space in between.
        */

            public static String joinStrings(String first, String second){
                StringJoiner joiner = (s1, s2) -> s1 + " " + s2;
                return joiner.join(first, second);
            }

        /*
            Create a functional interface that takes a single double as a parameter and returns a double.
            Implement it using a lambda expression to create a utility that returns the square root of the input value.
        */

            public static double getSquareRoot(double number){
                SquareRoot squareRoot = n -> Math.sqrt(n);
                return squareRoot.calculate(number);
            }

        /*
            Create a functional interface called PairMaker which takes two parameters of type T and U and returns a Pair object that holds both values.
            The Pair class should be a generic class that can hold two values of any types.
            Your task is to implement the PairMaker using a lambda expression to instantiate Pair objects with the given values.
        */

            public static <T,U> Pair<T,U> createPair(T key, U value){
                PairMaker<T,U> pairMaker = (t, u) -> new Pair<>(t, u);
                return pairMaker.create(key, value);
            }

        /*
            Create a functional interface named ListFilter that works with generics.
            It should have a method that takes a list of elements of type T and a predicate functional interface,
            applying the predicate to filter elements of the list, returning a new list with elements that satisfy the predicate condition.
            Implement the ListFilter using a lambda expression and demonstrate its usage with different types of lists and predicates.
        */

            public static <T> List<T> filterList(List<T> list, Predicate<T> predicate){
                ListFilter<T> listFilter = (elements, condition) -> applyPredicate(elements, condition);
                return listFilter.filter(list, predicate);
            }

            private static <T> List<T> applyPredicate(List<T> list, Predicate<T> predicate){
                List<T> result = new ArrayList<>();
                list.forEach(element -> {
                    if (predicate.test(element)) {
                        result.add(element);
                    }
                });
                return result;
            }
}
