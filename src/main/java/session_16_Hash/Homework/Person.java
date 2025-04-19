package session_16_Hash.Homework;

import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private String email;

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public boolean equals(Object o){
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return Objects.equals(name, person.name) && age == person.age;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, age);
    }
}

class TestPerson{
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30, "alice@yahoo.com");
        Person p2 = new Person("Alice", 30, "alice30@yahoo.com");
        Person p3 = new Person("Alice", 23, "alice@yahoo.com");

        System.out.println("p1 equals to p2? " + p1.equals(p2));
        System.out.println("p1 equals to p3? " + p1.equals(p3));
        System.out.println("p1 hashcode: " + p1.hashCode());
        System.out.println("p2 hashcode: " + p2.hashCode());
        System.out.println("p3 hashcode: " + p3.hashCode());
    }
}
