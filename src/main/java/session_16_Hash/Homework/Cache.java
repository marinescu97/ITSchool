package session_16_Hash.Homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cache<T> {
    private List<T> objects;

    public Cache() {
        objects = new ArrayList<>();
    }

    public void add(T o){
        if (!replaceObject(o)){
            objects.add(o);
        }
    }

    private boolean replaceObject(T o){
        for (T object : objects){
            if (object.hashCode() == o.hashCode()){
                objects.set(objects.indexOf(object), o);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return objects.toString();
    }
}

class Employee{
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o){
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class CacheSimulator{
    public static void main(String[] args) {
        Cache<Employee> cache = new Cache<>();
        cache.add(new Employee(1, "John"));
        cache.add(new Employee(2, "David"));
        cache.add(new Employee(3, "Alice"));

        System.out.println(cache);

        cache.add(new Employee(2, "Jane"));

        System.out.println(cache);
    }
}


