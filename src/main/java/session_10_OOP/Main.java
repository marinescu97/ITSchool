package session_10_OOP;

public class Main {
    public static void main(String[] args) {
//        Person person = new Person("Dan", 38);
//        System.out.println("Name: " + person.getName() + "\nAge: " + person.getAge());
//
//        person.setName("Ana");
//        person.setAge(73);
//
//        System.out.println();
//        person.getDetails();

        ContBancar contBancar1 = new ContBancar("Dan", 1000);
        ContBancar contBancar2 = new ContBancar("Ana", 5000);

        contBancar1.depunere(500);
        contBancar2.retragere(500);

        contBancar1.getDetails();
        System.out.println();
        contBancar2.getDetails();

        ContBancar.setDobanda(0.09);

        System.out.println("\nUpdate dobanda: ");
        contBancar1.getDetails();
        System.out.println();
        contBancar2.getDetails();
    }
}
