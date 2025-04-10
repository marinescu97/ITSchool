package session_13_OOP_4.Homework.Examples;

public class Bird {
    void fly(){
        System.out.println("Bird can fly");
    }
}

class Sparrow extends Bird{
    void sing(){
        System.out.println("Sparrow can sing");
    }
}

class TestBird{
    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        sparrow.fly();
        ((Sparrow) sparrow).sing();
    }
}
