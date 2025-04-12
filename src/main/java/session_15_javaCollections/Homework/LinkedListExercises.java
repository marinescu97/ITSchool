package session_15_javaCollections.Homework;

import java.util.*;

public class LinkedListExercises {
    // 1.Write a Java program to append the specified element to the end of a linked list.
    public static void appendToEnd(LinkedList<String> list, String element){
//        list.add(element);
        list.addLast(element);
    }

    // 2.Write a Java program to iterate through all elements in a linked list.
    public static void iterateList(LinkedList<String> list){
        for (String item : list){
            System.out.println(item);
        }
    }

    // 3.Write a Java program to iterate through all elements in a linked list starting at the specified position.
    public static void iterateFromIndex(LinkedList<String> list, int index){
        if (index < 0 || index >= list.size()){
            System.out.println("Invalid index.");
            return;
        }

//        for (int i = index; i < list.size(); i++){
//            System.out.println(list.get(i));
//        }

        ListIterator<String> iterator = list.listIterator(index);
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    // 4.Write a Java program to iterate a linked list in reverse order.
    public static void iterateReverse(LinkedList<String> list){
        Iterator<String> iterator = list.descendingIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    // 5.Write a Java program to insert the specified element at the specified position in the linked list.
    public static void insertElement(LinkedList<String> list, int index, String element){
        list.add(index, element);
    }

    // 6.Write a Java program to insert elements into the linked list at the first and last position.
    public static void insertFirstLast(LinkedList<String> list, String... elements){
        for (String element : elements){
            list.addFirst(element);
            list.addLast(element);
        }
    }

    // 7.Write a Java program to insert the specified element at the front of a linked list.
    public static void insertFirst(LinkedList<String> list, String element){
        list.addFirst(element);
    }

    // 8.Write a Java program to insert the specified element at the end of a linked list.
    public static void insertLast(LinkedList<String> list, String element){
        list.addLast(element);
    }

    // 9.Write a Java program to insert some elements at the specified position into a linked list.
    public static void insertAtPosition(LinkedList<String> list, int index, String... elements){
        list.addAll(index, List.of(elements));
    }

    // 10.Write a Java program to get the first and last occurrence of the specified elements in a linked list.
    public static void getFirstLastOccurence(LinkedList<String> list, String element){
        int firstIndex = list.indexOf(element);
        int lastIndex = list.lastIndexOf(element);

        if (firstIndex == -1){
            System.out.println("Element " + element + " not found in the list.");
        } else {
            System.out.println("First occurence at index " + firstIndex);
            System.out.println("Second occurence at index " + lastIndex);
        }
    }

    // 11.Write a Java program to display the elements and their positions in a linked list.
    public static void displayElementsAndPositions(LinkedList<String> list){
        for (int i = 0; i < list.size(); i++){
            System.out.println(i + ": " + list.get(i));
        }
    }

    // 12.Write a Java program to remove a specified element from a linked list.
    public static void removeElement(LinkedList<String> list, String element){
        list.removeIf(elem -> elem.equals(element));
    }

    // 13.Write a Java program to remove first and last element from a linked list.
    public static void removeFirstLast(LinkedList<String> list){
        list.removeFirst();
        list.removeLast();
    }

    // 14.Write a Java program to remove all the elements from a linked list.
    public static void removeAll(LinkedList<String> list){
        list.clear();
    }

    // 15.Write a Java program of swap two elements in a linked list.
    public static void swapElements(LinkedList<String> list, String firstElement, String secondElement){
        int firstElementIndex = list.indexOf(firstElement);
        int secondElementIndex = list.indexOf(secondElement);

        if (firstElementIndex != -1 && secondElementIndex != -1){
            Collections.swap(list, firstElementIndex, secondElementIndex);
        }
    }

    // 16.Write a Java program to shuffle the elements in a linked list.
    public static void shuffleElements(LinkedList<String> list){
        Collections.shuffle(list);
    }

    // 17.Write a Java program to join two linked lists.
    public static LinkedList<String> joinLists(LinkedList<String> firstList, LinkedList<String> secondList){
        LinkedList<String> result = new LinkedList<>(firstList);
        result.addAll(secondList);
        return result;
    }
    // 18.Write a Java program to clone a linked list to another linked list.
    public static LinkedList<String> cloneList(LinkedList<String> fromList){
        return new LinkedList<>(fromList);
    }

    // 19.Write a Java program to remove and return the first element of a linked list.
    public static String removeFirst(LinkedList<String> list){
        return list.removeFirst();
    }

    // 20.Write a Java program to retrieve but does not remove, the first element of a linked list.
    public static String retrieveFirstElement(LinkedList<String> list){
        return list.getFirst();
    }
}
