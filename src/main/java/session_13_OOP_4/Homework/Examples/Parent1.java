package session_13_OOP_4.Homework.Examples;

public class Parent1 {
    int value = 100;
}

class Child extends Parent1{
    int value = 200;
}

class Test{
    public static void main(String[] args) {
        Parent1 parent = new Child();
        System.out.println(parent.value);
    }
}
