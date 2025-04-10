package session_13_OOP_4.Homework.Examples;

public class Primate {
    public boolean hasHair(){
        return true;
    }
}

interface HasTail{
    boolean isTailStriped();
}

class Lemur extends Primate implements HasTail{
    public boolean isTailStriped(){
        return false;
    }

    public int age = 10;

    public static void main(String[] args) {
        Lemur lemur = new Lemur();
        System.out.println(lemur.age);

        HasTail hasTail = lemur;
        System.out.println(hasTail.isTailStriped());

        Primate primate = lemur;
        System.out.println(primate.hasHair());

//        Lemur lemur1 = primate;

        Lemur lemur1 = (Lemur) primate;
        System.out.println(lemur1.age);
    }
}
