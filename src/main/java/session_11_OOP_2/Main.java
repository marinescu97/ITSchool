package session_11_OOP_2;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Patrocle", "Dalmatian");
        dog.sound();

        System.out.println(dog.getName());
        System.out.println(dog.getRace());

        dog.setName("Leu");
        System.out.println(dog.getName());
    }
}
