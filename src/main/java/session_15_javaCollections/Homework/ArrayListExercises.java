package session_15_javaCollections.Homework;

import java.util.*;

public class ArrayListExercises {
    //1. Write a Java program to create a new array list, add some colors (string) and print out the collection.
    public static ArrayList<String> initializeList(){
        ArrayList<String> list = new java.util.ArrayList<>();

        list.add("Red");
        list.add("Green");
        list.add("Blue");
        list.add("Pink");
        list.add("Yellow");

        System.out.println(list);
        return list;
    }

    //2. Write a Java program to iterate through all elements in an array list.
    public static void printElements(ArrayList<String> list){
        for (String item : list){
            System.out.println(item);
        }
    }

    //3. Write a Java program to insert an element into the array list at the first position.
    public static void insertFirst(ArrayList<String> list, String element){
//        list.add(0, element);
        list.addFirst(element);
    }

    //4. Write a Java program to retrieve an element (at a specified index) from a given array list.
    public static String getElement(ArrayList<String> list, int index){
        if (index < 0 || index >= list.size()){
            System.out.println("Invalid index");
            return null;
        }

        return list.get(index);
    }

    //5. Write a Java program to update specific array element by given element.
    public static void updateElement(ArrayList<String> list, String oldElement, String newElement){
        if (!list.contains(oldElement)){
            System.out.println("The element " + oldElement + " doesn't exist.");
            return;
        }

        list.set(list.indexOf(oldElement), newElement);
    }

    //6. Write a Java program to remove the third element from an array list.
    public static void removeThirdElement(ArrayList<String> list){
        if (list.size() >= 3){
            list.remove(2);
        }
    }

    //7. Write a Java program to search an element in an array list.
    public static int searchElement(ArrayList<String> list, String element){
        sortList(list);
        return Collections.binarySearch(list, element);
    }

    public static int getIndex(ArrayList<String> list, String element){
        return list.indexOf(element);
    }

    //8. Write a Java program to sort a given array list.
    public static void sortList(ArrayList<String> list){
//        list.sort(null);
//        list.sort((s1, s2) -> s1.compareTo(s2));
        list.sort(String::compareTo);
    }

    //9. Write a Java program to copy one array list into another.
    public static List<String> copyList(ArrayList<String> list){
//        List<String> copy = new java.util.ArrayList<>();
//        copy.addAll(list);
//        return copy;

//        List<String> copy = new java.util.ArrayList<>(Collections.nCopies(list.size(), ""));
//        Collections.copy(copy, list);
//        return copy;

        return new java.util.ArrayList<>(list);
    }

    //10. Write a Java program to shuffle elements in an array list.
    public static void shuffleElements(ArrayList<String> list){
//        Collections.shuffle(list);
        Collections.shuffle(list, new Random(3));
    }

    //11. Write a Java program to reverse elements in an array list.
    public static List<String> reverseList(ArrayList<String> list){
        return list.reversed();
    }

    //12. Write a Java program to extract a portion of an array list.
    public static List<String> extractPortion(ArrayList<String> list, int from, int to){
        return list.subList(from, to);
    }

    //13. Write a Java program to compare two array lists.
    public static boolean compareLists(ArrayList<String> firstList, ArrayList<String> secondList){
        return firstList.equals(secondList);
    }

    //14. Write a Java program of swap two elements in an array list.
    public static void swapElements(ArrayList<String> list, int firstElemIndex, int secondElemIndex){
        if ((firstElemIndex >= 0 && firstElemIndex < list.size()) && (secondElemIndex >= 0 && secondElemIndex < list.size())){
            Collections.swap(list, firstElemIndex, secondElemIndex);
        }
    }

    //15. Write a Java program to join two array lists.
    public static ArrayList<String> joinLists(ArrayList<String> firstList, ArrayList<String> secondList){
        ArrayList<String> result = new ArrayList<>(firstList);
        result.addAll(secondList);
        return result;
    }

    //16. Write a Java program to clone an array list to another array list.
    public static ArrayList<String> cloneList(ArrayList<String> fromList){
        return new ArrayList<>(fromList);
    }

    //17. Write a Java program to empty an array list.
    public static void emptyList(ArrayList<String> list){
        list.clear();
    }

    //18. Write a Java program to test an array list is empty or not.
    public static boolean checkIsEmpty(ArrayList<String> list){
        return list.isEmpty();
    }

    //19. Write a Java program to trim the capacity of an array list the current list size.
    public static void trimToSize(ArrayList<String> list){
        list.trimToSize();
    }

    //20. Write a Java program to increase the size of an array list.
    public static void increaseCapacity(ArrayList<String> list){
        list.ensureCapacity(20);
    }
}
