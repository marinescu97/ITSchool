package session_10_OOP.Homework.SimpleBankingApplication;

public class Test {
    public static void main(String[] args) {
        Account account = new Account("Jane", "Smith");

        account.withdraw(20);
        account.deposit(50);
        System.out.println();
        account.withdraw(12);

        System.out.println();
        System.out.println("Current balance: " + account.getBalance());
    }
}
