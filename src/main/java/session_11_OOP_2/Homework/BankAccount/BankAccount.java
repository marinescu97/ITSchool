package session_11_OOP_2.Homework.BankAccount;

public class BankAccount {
    private final String accountHolder;
    private final int accountNumber;
    private static int counter = 100;
    private double balance;

    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.accountNumber = counter++;
        this.balance = 0d;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        if (amount > 0){
            balance += amount;
            System.out.println("Your deposit of $" + amount + " has been successfully processed.");
        } else {
            System.out.println("Please enter a valid amount.");
        }
    }

    public void withdraw(double amount){
        if (amount <= 0){
            System.out.println("Please enter a valid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds");
        } else {
            balance -= amount;
            System.out.println("Your withdrawal of $" + amount + " has been successfully processed.");
        }
    }

    public void printAccountDetails(){
        System.out.printf("""
                
                Account number: %d
                Holder: %s
                Balance: %.2f
                """, accountNumber, accountHolder, balance);
    }

    public void transferFunds(BankAccount targetAccount, double amount){
        this.withdraw(amount);
        targetAccount.deposit(amount);
    }
}
