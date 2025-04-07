package session_12_OOP_3.Homework;

public abstract class A_Class {
    public A_Class() {
        System.out.println("This is constructor of abstract class.");
    }

    public abstract void a_method();

    public void normalMethod(){
        System.out.println("This is a normal method of abstract class.");
    }
}

class SubClass extends A_Class{

    @Override
    public void a_method() {
        System.out.println("This is abstract method.");
    }
}

class TestA_Class{
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.a_method();
        subClass.normalMethod();
    }
}
