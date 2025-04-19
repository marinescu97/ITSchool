package session_16_Hash.Homework;

public class Pair<K,V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" + key + ", " + value + '}';
    }
}

class TestPair{
    public static void main(String[] args) {
        Pair<String, Double> product = new Pair<>("Tomatoes", 2.3);
        System.out.println("Product: " + product);

        Pair<Integer, String> person = new Pair<>(1, "Jane");
        System.out.println("Person: " + person);
    }
}
