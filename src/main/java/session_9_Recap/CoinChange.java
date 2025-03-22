package session_9_Recap;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(changeCoin(93));
    }

    public static int changeCoin(int amount){
        int[] coinDenominations = {25, 10, 5, 1};
        int coins;
        int total = 0;

        for (int coinDenomination : coinDenominations) {
            coins = 0;
            while (amount >= coinDenomination) {
                amount -= coinDenomination;
                coins++;
            }
            total += coins;
        }
        return total;
    }
}
