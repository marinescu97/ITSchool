package session_8_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        performance();
    }

    public static void arrayExample(){
        String[] friends = {"Ion", "Bob", "Dan", "Mioara"};

        System.out.println("one friend: " + friends[0]);

        System.out.println("Dimensiunea lui friends este: " + friends.length);

        friends[1] = "Marcel";

        System.out.println("Friends pe pozitia 1: " + friends[1]);

        System.out.println("All my friends: " + Arrays.toString(friends));
    }

    public static void arrayExample2(){
        int[] numbers = {15, 24, 7, 4, 90};
        System.out.println("All numbers: " + Arrays.toString(numbers));

        Arrays.sort(numbers);
        System.out.println("All numbers sorted: " + Arrays.toString(numbers));

        int target = 7;
        int index = Arrays.binarySearch(numbers, target);
        System.out.println("Pozitia unde a gasit target este: " + index);
        System.out.println("Valoarea de pe pozitie este: " + numbers[index]);
    }

    public static void arrayExample3(){
        String[] cities = {"Iasi", "Bucuresti", "Cluj"};
        Arrays.sort(cities);
        System.out.println(Arrays.toString(cities));
        int index = Arrays.binarySearch(cities, "Cluj");
        System.out.println(index);
        System.out.println(cities[index]);
    }

    public static void arrayListExample(){
        List<String> friends = new ArrayList<>(Arrays.asList("Ion", "Bob", "Dan", "Mioara"));
        System.out.println("Friend de pe pozitia 2: " + friends.get(2));
        System.out.println("Dimensiunea lui friends: " + friends.size());

        friends.add("Marcel");
        System.out.println("Friends: " + friends);

        friends.remove("Bob");
        System.out.println("Friends fara Bob: " + friends);
        System.out.println("Este oare Bob in friends? " + friends.contains("Bob"));
        System.out.println("Este oare Marcel in friends? " + friends.contains("Marcel"));

        friends.remove(1);
        System.out.println(friends);

        friends.set(1, "Bob");
        System.out.println(friends);

        friends.add(2, "Ioana");
        System.out.println(friends);

        friends.clear();
        System.out.println(friends);
    }

    public static void linkedListExample(){
        List<String> list = new LinkedList<>();

        list.add("Ion");
        list.add("Bob");
        list.add("Dan");

        System.out.println("list [1]: " + list.get(1));

        list.add(1, "Marcel");
        System.out.println("list [1]: " + list.get(1));
        System.out.println(list);

        list.remove("Marcel");
        System.out.println(list);
        System.out.println();

        LinkedList<String> stack = new LinkedList<>();
        stack.push("Ion");
        stack.push("Bob");
        stack.push("Dan");
        System.out.println("Stack: " + stack);

        stack.pop();
        System.out.println("Stack: " + stack);

        System.out.println(stack.get(1));
    }

    public static void multidimensionalExample(){
        String[][] names = {
                {"Ms", "Mr", "Mrs"},
                {"Ion", "Marcel", "Mioara"}
        };

        System.out.println(names[0][0] + " " + names[1][2]);
        System.out.println(names[0][2] + " " + names[1][1]);

        for (int i = 0; i < names.length; i++){
            for (int j = 0; j < names[i].length; j++){
                System.out.print(names[i][j] + " ");
            }
            System.out.println();
        }

        for (String[] arr : names){
            for (String name : arr){
                System.out.print(name);
            }
            System.out.println();
        }
    }

    public static void performance(){
        final int size = 500_000;

        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        for (int i = 0; i < size; i++){
            String value = String.valueOf(i);
            arrayList.add(value);
            linkedList.add(value);
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++){
            arrayList.get(size / 2);
        }

        long stopTimeArrayList = System.currentTimeMillis() - start;

        long startLinked = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++){
            linkedList.get(size / 2);
        }

        long stopTimeLinkedList = System.currentTimeMillis() - startLinked;

        System.out.println("Access arrayList: " + stopTimeArrayList);
        System.out.println("Access linkedList: " + stopTimeLinkedList);

        long startAddedArray = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++){
            arrayList.add(0, "X");
        }

        long stopAddedArray = System.currentTimeMillis() - startAddedArray;

        System.out.println("Added arrayList: " + stopAddedArray);

        long startAddedLinked = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++){
            linkedList.add(0, "X");
        }

        long stopAddedLinked = System.currentTimeMillis() - startAddedLinked;

        System.out.println("Added linkedList: " + stopAddedLinked);
    }
}
