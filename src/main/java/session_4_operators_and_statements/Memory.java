package session_4_operators_and_statements;

import java.util.Objects;

public class Memory {
    public static void main(String[] args) {
        String hello1 = "hello";
        String hello2 = "Hello";
        String hello3 = new String("Hello");

//        System.out.println(hello1 == hello2);
//        System.out.println(hello1.equals(hello2));
//        System.out.println(hello2 == hello3);
//        System.out.println(hello2.equals(hello3));

        User user1 = new User("Monica");
        User user2 = new User("Monica");

        System.out.println(user1 == user2);
        System.out.println(user1.equals(user2));

        Pacient pacient1 = new Pacient();
        String afisareText = pacient1.afisareText();
        System.out.println(afisareText);
    }
}

class User{
    String firstName;

    public User(String firstName){
        this.firstName = firstName;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return Objects.equals(firstName, user.firstName);
    }
}
