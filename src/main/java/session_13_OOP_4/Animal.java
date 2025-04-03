package session_13_OOP_4;

public class Animal {
    public void makeSound(){
        System.out.println("Animal makes sounds");
    }

    public void sleep(){
        System.out.println("sleep");
    }
}

class Dog extends Animal{
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }

    public void animalMakeSound(){
        super.makeSound();
    }

    @Override
    public void sleep() {
        System.out.println("Dog sleeps");
    }

    public void fetch(){
        System.out.println("Dog gets the ball");
    }
}

class Cat extends Animal{
    @Override
    public void makeSound() {
        System.out.println("Cat makes sound");
    }

    @Override
    public void sleep() {
        System.out.println("Cat sleeps");
    }

    public void scratch(){
        System.out.println("Cat scratch");
    }
}

class SuperMain{
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();
        dog.animalMakeSound();
    }
}

class AnimalMain{
    public static void main(String[] args) {
        Animal myAnimal = new Dog();
        myAnimal.makeSound();
        myAnimal.sleep();
        ((Dog) myAnimal).fetch();

        try {
            Cat myCat = (Cat) myAnimal;
            myCat.makeSound();
        } catch (ClassCastException ex){
            System.out.println("Eroare la cast dintre un maine si o pisica: " + ex);
        }

        Animal animal = new Cat();
        Cat cat = (Cat) animal;
        cat.makeSound();
        cat.sleep();
        cat.scratch();

        System.out.println(cat instanceof Cat);
        System.out.println(animal instanceof Cat);
        System.out.println(myAnimal instanceof Dog);
    }
}
