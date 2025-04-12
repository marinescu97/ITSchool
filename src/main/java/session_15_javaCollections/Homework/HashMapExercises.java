package session_15_javaCollections.Homework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapExercises {
    private HashMap<String, Integer> map;

    public HashMapExercises() {
        map = new HashMap<>();
    }

    // 1.Write a Java program to associate the specified value with the specified key in a HashMap.
    public void addKeyValue(String key, Integer value){
        map.put(key, value);
    }

    // 2.Write a Java program to count the number of key-value (size) mappings in a map.
    public int getSize(){
        return map.size();
    }

    // 3.Write a Java program to copy all the mappings from the specified map to another map.
    public HashMap<String, Integer> copyMap(){
        return new HashMap<>(map);
    }

    // 4.Write a Java program to remove all the mappings from a map.
    public void removeAll(){
        map.clear();
    }

    // 5.Write a Java program to check whether a map contains key-value mappings (empty) or not.
    public boolean checkIsEmpty(){
        return map.isEmpty();
    }

    // 6.Write a Java program to get a shallow copy of a HashMap instance.
    public HashMap<String, Integer> getCopy(){
        return (HashMap<String, Integer>) map.clone();
    }

    // 7.Write a Java program to test if a map contains a mapping for the specified key.
    public boolean containsMappingKey(String key){
        return map.containsKey(key);
    }

    // 8.Write a Java program to test if a map contains a mapping for the specified value.
    public boolean containsMappingValue(Integer value){
        return map.containsValue(value);
    }

    // 9.Write a Java program to create a set view of the mappings contained in a map.
    public void displayMap(){
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // 10.Write a Java program to get the value of a specified key in a map.
    public int getValue(String key){
        return map.get(key);
    }

    // 11.Write a Java program to get a set view of the keys contained in this map.
    public Set<String> displayKeys(){
        return map.keySet();
    }

    // 12.Write a Java program to get a collection view of the values contained in this map.
    public Collection<Integer> displayValues(){
        return map.values();
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
