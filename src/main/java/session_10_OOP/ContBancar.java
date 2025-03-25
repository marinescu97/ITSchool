package session_10_OOP;

public class ContBancar {
    private String titular;
    private int sold;

    private static double dobanda = 0.08d;

    public ContBancar(String titular, int soldInitial){
        this.titular = titular;
        this.sold = soldInitial;
    }

    public void depunere(int suma){
        if (suma > 0){
            sold += suma;
        } else {
            System.out.println("Nu puteti depune o suma negativa!");
        }
    }

    public void retragere(int suma){
        if (suma > 0 && suma <= sold){
            sold -= suma;
        } else {
            System.out.println("Valoare invalida suma!");
        }
    }

    public static void setDobanda(double dobandaNoua){
        if (dobandaNoua >= 0){
            dobanda = dobandaNoua;
        } else {
            System.out.println("Eroare la setarea dobanzii.");
        }
    }

    public void getDetails(){
        System.out.println("Titular: " + titular);
        System.out.println("Sold: " + sold);
        System.out.println("Dobanda: " + dobanda);
    }
}
