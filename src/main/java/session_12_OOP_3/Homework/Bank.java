package session_12_OOP_3.Homework;

public abstract class Bank {
    public abstract void getBalance();
}

class BankA extends Bank{
    @Override
    public void getBalance() {
        System.out.println("$100");
    }
}

class BankB extends Bank{
    @Override
    public void getBalance() {
        System.out.println("$150");
    }
}

class BankC extends Bank{
    @Override
    public void getBalance() {
        System.out.println("$200");
    }
}

class TestBank{
    public static void main(String[] args) {
        BankA bankA = new BankA();
        BankB bankB = new BankB();
        BankC bankC = new BankC();

        bankA.getBalance();
        bankB.getBalance();
        bankC.getBalance();
    }
}
