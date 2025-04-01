package session_12_OOP_3;

public abstract class Animal {
    public void eat(){
        System.out.println("This animal eats food.");
    }

    public abstract void makeSound();
}

interface Pet{
    void poop();
}

class Cat extends Animal implements Pet{

    @Override
    public void makeSound() {
        System.out.println("Meow");
    }

    @Override
    public void poop() {
        System.out.println("Yes");
    }

    @Override
    public void eat() {
        System.out.println("Cat eats mouse.");
    }
}
