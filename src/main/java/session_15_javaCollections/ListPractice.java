package session_15_javaCollections;

import java.util.ArrayList;
import java.util.List;

public class ListPractice {
    public static void main(String[] args) {
        List<Integer> myList = initializeList();
        System.out.println("Initial list: " + myList);

        List<Integer> myUpdatedList = updateList(myList, 5, 600);
        System.out.println("Updated list: " + myUpdatedList);

        System.out.println("Element 5 is present? " + isElementPresent(myUpdatedList, 5));
    }

    public static boolean isElementPresent(List<Integer> list, int element){
        return list.contains(element);
    }

    public static List<Integer> updateList(List<Integer> myList, int index, int newValue){
        if (index < 0 || index > myList.size()){
            System.out.println("Invalid index.");
            return myList;
        }

        List<Integer> result = new ArrayList<>(myList);
        result.set(index, newValue);
        return result;
    }

    public static List<Integer> initializeList(){
        List<Integer> list = new ArrayList<>();

        for (int index = 0; index < 10; index ++){
            list.add(index);
        }
        return list;
    }
}
