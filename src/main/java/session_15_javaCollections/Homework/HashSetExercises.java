package session_15_javaCollections.Homework;

import java.util.*;

public class HashSetExercises {
    private HashSet<String> set;

    public HashSetExercises() {
        set = new HashSet<>();
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(HashSet<String> set) {
        this.set = set;
    }

    public void addElements(String... elements){
        set.addAll(List.of(elements));
    }

    // 1.Write a Java program to append the specified element to the end of a hash set.
    public LinkedHashSet<String> appendElement(String element){
        LinkedHashSet<String> result = new LinkedHashSet<>(set);
        result.add(element);
        return result;
    }

    // 2.Write a Java program to iterate through all elements in a hash list.
    public void iterateElements(){
//        set.forEach(System.out::println);

//        Iterator<String> iterator = set.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        for (String string : set) {
            System.out.println(string);
        }
    }

    // 3.Write a Java program to get the number of elements in a hash set.
    public int getElementsNumber(){
        return set.size();
    }

    // 4.Write a Java program to empty a hash set.
    public void emptySet(){
        set.clear();
    }

    // 5.Write a Java program to test a hash set is empty or not.
    public boolean checkIsEmpty(){
        return set.isEmpty();
    }

    // 6.Write a Java program to clone a hash set to another hash set.
    public HashSet<String> cloneSet(){
        return new HashSet<>(set);
    }

    // 7.Write a Java program to convert a hash set to an array.
    public String[] setToArray(){
        return set.toArray(new String[0]);
    }

    // 8.Write a Java program to convert a hash set to a tree set.
    public TreeSet<String> setToTreeSet(){
        return new TreeSet<>(set);
    }

    // 9.Write a Java program to convert a hash set to a List/ArrayList .
    public ArrayList<String> setToArrayList(){
        return new ArrayList<>(set);
    }

    // 10.Write a Java program to compare two hash set.
    public boolean areEquals(HashSet<String> anotherSet){
        return set.equals(anotherSet);
    }

    // 11.Write a Java program to compare two sets and retain elements which are same on both sets.
    public HashSet<String> retainElements(HashSet<String> anotherSet){
        HashSet<String> result = new HashSet<>(set);
        result.retainAll(anotherSet);
        return result;
    }

    // 12.Write a Java program to remove all the elements from a hash set.
    public void removeAllElements(){
        set.clear();
    }

    @Override
    public String toString() {
        return set.toString();
    }
}
