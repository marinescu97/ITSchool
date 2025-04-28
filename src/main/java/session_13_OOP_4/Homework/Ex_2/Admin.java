package session_13_OOP_4.Homework.Ex_2;

public class Admin extends User{

    public Admin(String name) {
        super(name);
    }

    public void applyChanges(){
        System.out.println(getName() + " applies changes to the application.");
    }
}
