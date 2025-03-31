package session_11_OOP_2.Homework.BankAccount;

public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount smithAccount = new BankAccount("Jane Smith");

        smithAccount.deposit(50);
        smithAccount.withdraw(10.5);

        BankAccount williamsAccount = new BankAccount("Alice Williams");

        System.out.println("\nBefore transfer:");
        smithAccount.printAccountDetails();
        williamsAccount.printAccountDetails();

        smithAccount.transferFunds(williamsAccount, 5);

        System.out.println("\nAfter transfer:");
        smithAccount.printAccountDetails();
        williamsAccount.printAccountDetails();
    }
}
