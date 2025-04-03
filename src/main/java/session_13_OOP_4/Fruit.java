package session_13_OOP_4;

public class Fruit {
    public String taste(){
        return "Fruit has taste";
    }

    public String colour(){
        return "Fruit has colour";
    }
}

class Apple extends Fruit{
    @Override
    public String taste(){
        return "Apple is sweet";
    }

    @Override
    public String colour(){
        return "Apple is red";
    }
}

class Orange extends Fruit{
    @Override
    public String taste(){
        return "Orange is sour";
    }

    @Override
    public String colour(){
        return "Orange is orange";
    }
}

class FruitTest{
    public static void main(String[] args) {
        printFruit(new Apple());
        printFruit(new Orange());
    }

    public static void printFruit(Fruit fruit){
        System.out.println("Taste: " + fruit.taste());
        System.out.println("Colour: " + fruit.colour());
    }
}
