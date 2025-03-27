package session_11_OOP_2;

public class Animal {
    private String name;

    public Animal(String name){
        this.name = name;
    }

    // Getter
    public String getName(){
        return name;
    }

    //Setter
    public void setName(String name){
        this.name = name;
    }

    public void sound(){
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal{
    private String race;

    public Dog(String name, String race){
        super(name);
        this.race = race;
    }

    public String getRace(){
        return race;
    }

    public void setRace(String race){
        this.race = race;
    }

    @Override
    public void sound(){
        System.out.println("The dog barks.");
    }
}
