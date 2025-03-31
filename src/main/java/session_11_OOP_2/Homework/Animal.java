package session_11_OOP_2.Homework;

public class Animal {
    public void sound(){
        System.out.println("animal makes sound");
    }
}

class Dog extends Animal{
    @Override
    public void sound() {
        System.out.println("bark");
    }
}

class Cat extends Animal{
    @Override
    public void sound() {
        System.out.println("meow");
    }
}

class Wolf extends Animal{
    @Override
    public void sound() {
        System.out.println("how");
    }
}

class TestAnimal{
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Wolf wolf = new Wolf();

        dog.sound();
        cat.sound();
        wolf.sound();
    }
}
