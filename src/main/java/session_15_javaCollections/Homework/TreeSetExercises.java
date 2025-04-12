package session_15_javaCollections.Homework;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExercises {
    private TreeSet<Integer> set;

    public Set<Integer> getSet() {
        return set;
    }

    public void setSet(TreeSet<Integer> set) {
        this.set = set;
    }

    // 1.Write a Java program to create a new tree set, add some colors (string) and print out the tree set.
    public void initializeAndPrint(Integer... elements){
        set = new TreeSet<>();
        set.addAll(List.of(elements));
        System.out.println(set);
    }

    // 2.Write a Java program to iterate through all elements in a tree set.
    public void iterateAndPrint(){
        for (Integer element : set) {
            System.out.println(element);
        }
    }

    // 3.Write a Java program to add all the elements of a specified tree set to another tree set.
    public void addFromSet(TreeSet<Integer> elementsToAdd){
        set.addAll(elementsToAdd);
    }

    // 4.Write a Java program to create a reverse order view of the elements contained in a given tree set.
    public void printReverse(TreeSet<Integer> set){
        System.out.println(set.descendingSet());
    }

    // 5.Write a Java program to get the first and last elements in a tree set.
    public void getFirstAndLast(){
        System.out.println(set.first());
        System.out.println(set.last());
    }

    // 6.Write a Java program to clone a tree set list to another tree set.
    public TreeSet<Integer> cloneTreeSet(){
        return new TreeSet<>(set);
    }

    // 7.Write a Java program to get the number of elements in a tree set.
    public int getElementsNumber(){
        return set.size();
    }

    // 8.Write a Java program to compare two tree sets.
    public boolean isEqualTo(TreeSet<Integer> set){
        return this.set.equals(set);
    }

    // 9.Write a Java program to find the numbers less than 7 in a tree set.
    public TreeSet<Integer> findElementsLessThan(int number){
        return new TreeSet<>(set.headSet(number));
    }

    // 10.Write a Java program to get the element in a tree set which is greater than or equal to the given element.
    public Integer getGreaterThanOrEqualTo(int number){
        return set.ceiling(number);
    }

    // 11.Write a Java program to get the element in a tree set which is less than or equal to the given element.
    public Integer getLessThanOrEqualTo(int number){
        return set.floor(number);
    }

    // 12.Write a Java program to get the element in a tree set which is strictly greater than the given element.
    public Integer getGreaterThan(int number){
        return set.higher(number);
    }

    // 13.Write a Java program to get an element in a tree set which is strictly less than the given element.
    public Integer getLessThan(int number){
        return set.lower(number);
    }

    // 14.Write a Java program to retrieve and remove the first element of a tree set.
    public int retrieveAndRemoveFirst(){
        return set.removeFirst();
    }

    // 15.Write a Java program to retrieve and remove the last element of a tree set.
    public int retrieveAndRemoveLast(){
        return set.removeLast();
    }

    // 16.Write a Java program to remove a given element from a tree set.
    public void removeElement(int element){
        set.removeIf(e -> e.equals(element));
    }

    @Override
    public String toString() {
        return set.toString();
    }
}
