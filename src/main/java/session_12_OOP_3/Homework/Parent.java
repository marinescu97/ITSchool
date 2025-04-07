package session_12_OOP_3.Homework;

public abstract class Parent {
    public void message(){
        System.out.println("This is the Parent class.");
    }
}

class First extends Parent{
    @Override
    public void message() {
        System.out.println("This is first subclass.");
    }
}

class Second extends Parent{
    @Override
    public void message() {
        System.out.println("This is second subclass.");
    }
}

class Main{
    public static void main(String[] args) {
        First firstClass = new First();
        firstClass.message();

        Second secondClass = new Second();
        secondClass.message();
    }
}
