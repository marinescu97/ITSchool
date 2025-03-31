package session_10_OOP.Homework.SimpleBankingApplication;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String firstName;
    private String lastName;
    private double balance;
    private final List<String> transactions;

    public Account(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = 0d;
        transactions = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        if (amount > 0){
            balance += amount;
            transactions.add("Deposit: $" + amount + " -> New balance: " + balance);
            System.out.println("Your deposit of $" + amount + " has been successfully processed.");
            printTransactions();
        } else {
            System.out.println("Please deposit a valid amount!");
        }
    }

    public void withdraw(double amount){
        if (amount <= 0){
            System.out.println("Please enter a valid amount.");
        } else if (amount >= balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            transactions.add("Withdrawal: $" + amount + " -> New balance: " + balance);
            System.out.println("Your withdrawal of $" + amount + " has been successfully processed.");
            printTransactions();
        }
    }

    public void printTransactions(){
        System.out.println("Transactions:");
        transactions.forEach(System.out::println);
    }
}
