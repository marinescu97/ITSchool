package session_29_Concurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionExample {
    public static void main(String[] args) {
//        Map<String, String> stringMap = new HashMap<>();
        Map<String, String> stringMap = new ConcurrentHashMap<>();
        stringMap.put("Marcus", "Java");
        stringMap.put("Marcel", "JS");

//        Set<String> keys = new HashSet<>(stringMap.keySet());
//
//        for (String key : keys){
//            System.out.println(key + " codes in " + stringMap.get(key));
//            stringMap.remove(key);
//        }

        for (String key : stringMap.keySet()){
            System.out.println(key + " codes in " + stringMap.get(key));
            stringMap.remove(key);
        }
    }
}
