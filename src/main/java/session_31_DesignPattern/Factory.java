package session_31_DesignPattern;

interface Animal{
    void makeSound();
}

class Dog implements Animal{
    @Override
    public void makeSound() {
        System.out.println("bark bark");
    }
}

class Cat implements Animal{
    @Override
    public void makeSound() {
        System.out.println("meow meow");
    }
}

class Lion implements Animal{
    @Override
    public void makeSound() {
        System.out.println("lion lion");
    }
}

class AnimalFactory{
    public Animal createAnimal(String type){
        if (type.equalsIgnoreCase("dog")){
            return new Dog();
        } else if (type.equalsIgnoreCase("cat")) {
            return new Cat();
        } else if (type.equalsIgnoreCase("lion")) {
            return new Lion();
        }

        return null;
    }
}

public class Factory {
    public static void main(String[] args) {
        AnimalFactory factory = new AnimalFactory();
        Animal dog = factory.createAnimal("dog");
        Animal cat = factory.createAnimal("cat");
        Animal lion = factory.createAnimal("lion");

        dog.makeSound();
        cat.makeSound();
        lion.makeSound();
    }
}
