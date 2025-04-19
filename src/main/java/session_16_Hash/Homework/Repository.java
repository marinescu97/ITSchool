package session_16_Hash.Homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Repository<K,V> {
    private Map<K, V> map;

    public Repository() {
        map = new HashMap<>();
    }

    public void add(K key, V value) {
        map.put(key, value);
    }

    public V findByKey(K key) {
        return map.get(key);
    }

    public void delete(K key) {
        map.remove(key);
    }

    public boolean exists(K key) {
        return map.containsKey(key);
    }

    public int getSize(){
        return map.size();
    }

    public void clear(){
        map.clear();
    }

    public void printAll() {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Repository<?, ?> that = (Repository<?, ?>) o;
        return Objects.equals(map, that.map);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(map);
    }
}

class TestRepository{
    public static void main(String[] args) {
        Repository<Integer, String> repository = new Repository<>();

        repository.add(1, "Object 1");
        repository.add(2, "Object 2");

        System.out.println("Object with key 1: " + repository.findByKey(1));

        System.out.println("Size of repository: " + repository.getSize());

        repository.delete(1);
        System.out.println("Size after removal: " + repository.getSize());

        System.out.println("Contains key 1: " + repository.exists(1));
        System.out.println("Contains key 2: " + repository.exists(2));
    }
}
