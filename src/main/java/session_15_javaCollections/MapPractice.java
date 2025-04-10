package session_15_javaCollections;

import java.util.HashMap;
import java.util.Map;

public class MapPractice {
    public static void main(String[] args) {
        Map<String, Integer> students = initializeMap();
        System.out.println(students);
        updateMap(students, "Mera", 12);
        System.out.println(students);
        System.out.println(getAge(students, "Mera"));

        for (Map.Entry<String, Integer> entry : students.entrySet()){
            String name = entry.getKey();
            int age = entry.getValue();

            System.out.println(name + ": " + age);
        }
    }

    public static int getAge(Map<String, Integer> map, String name){
        return map.get(name);
    }

    public static void updateMap(Map<String, Integer> map, String name, int value){
        map.put(name, value);
    }

    public static Map<String, Integer> initializeMap(){
        Map<String, Integer> students = new HashMap<>();

        students.put("Marcel", 38);
        students.put("Dan", 29);
        students.put("Marcela", 45);
        students.put("Vio", 19);

        return students;
    }
}
