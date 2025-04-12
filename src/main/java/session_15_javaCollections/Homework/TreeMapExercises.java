package session_15_javaCollections.Homework;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExercises {
    TreeMap<String, Integer> map;

    //1.Write a Java program to associate the specified value with the specified key in a Tree Map.
    public void addKeyValue(String key, Integer value){
        map.put(key, value);
    }

    public TreeMapExercises() {
        this.map = new TreeMap<>();
    }

    //2.Write a Java program to copy a Tree Map content to another Tree Map.
    public TreeMap<String, Integer> copyMap(){
        return new TreeMap<>(map);
    }

    //3.Write a Java program to search a key in a Tree Map.
    public boolean containsKey(String key){
        return map.containsKey(key);
    }

    //4.Write a Java program to search a value in a Tree Map.
    public boolean containsValue(int value){
        return map.containsValue(value);
    }

    //5.Write a Java program to get all keys from the given a Tree Map.
    public void getAllKeys(){
        System.out.println(map.keySet());
    }

    //6.Write a Java program to delete all elements from a given Tree Map.
    public void deleteAll(){
        map.clear();
    }

    //7.Write a Java program to sort keys in Tree Map by using comparator.
    public TreeMap<String, Integer> sortKeys(){
        TreeMap<String, Integer> result = new TreeMap<>(Comparator.comparing(key -> map.get(key)));
        result.putAll(map);
        return result;
    }

    //8.Write a Java program to get a key-value mapping associated with the greatest key and the least key in a map.
    public void getGreatestAndLeastKey(){
        System.out.println("Greatest key: " + map.lastEntry());
        System.out.println("Least key: " + map.firstEntry());
    }

    //9.Write a Java program to get the first (lowest) key and the last (highest) key currently in a map.
    public void getFirstLastKey(){
        System.out.println("First key: " + map.firstKey());
        System.out.println("Last key: " + map.lastKey());
    }

    //10.Write a Java program to get a reverse order view of the keys contained in a given map.
    public Map<String, Integer> getReverse(){
        return map.descendingMap();
    }

    //11.Write a Java program to get a key-value mapping associated with the greatest key less than or equal to the given key.
    public void getMappingLessThanOrEqualTo(String key){
        System.out.println("Greatest key less than or equal to " + key + ": " + map.floorEntry(key));
    }

    //12.Write a Java program to get the greatest key less than or equal to the given key.
    public void getKeyLessThanOrEqualTo(String key){
        System.out.println("Greatest key less than or equal to " + key + ": " + map.floorKey(key));
    }

    //13.Write a Java program to get the portion of a map whose keys are strictly less than a given key.
    public void getPortionLessThan(String key){
        System.out.println("Portion strictly less than " + key + ": " + map.headMap(key));
    }

    //14.Write a Java program to get the portion of this map whose keys are less than (or equal to, if inclusive is true) a given key.
    public void getPortionLessThanOrEqualTo(String key){
        System.out.println("Portion less than or equal to " + key + ": " + map.headMap(key, true));
    }

    //15.Write a Java program to get the least key strictly greater than the given key. Return null if there is no such key.
    public void getKeyGreaterThan(String key){
        System.out.println("Least key greater than " + key + ": " + map.higherKey(key));
    }

    //16.Write a Java program to get a key-value mapping associated with the greatest key strictly less than the given key. Return null if there is no such key.
    public void getMappingLessThan(String key){
        System.out.println("Greatest key strictly less than " + key + ": " + map.lowerEntry(key));
    }

    //17.Write a Java program to get the greatest key strictly less than the given key. Return null if there is no such key.
    public void getKeyLessThan(String key){
        System.out.println("Greatest key strictly less than " + key + ": " + map.lowerKey(key));
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
