package session_15_javaCollections.Homework.Challenge;

public class Test {
    public static void main(String[] args) {
        ShoppingCart cart1 = new ShoppingCart();
        cart1.addProducts("Banana", "Apples", "Chocolate", "Milk", "Eggs", "Apples");

        ShoppingCart cart2 = new ShoppingCart();
        cart2.addProducts("Chocolate", "Strawberries", "Onions", "Cereal");

        ShoppingCart cart3 = new ShoppingCart();
        cart3.addProducts("Cereal", "Flour", "Cheese", "Tomatoes", "Juice", "Apples", "Potatoes", "Cookies");

        ShoppingCart cart4 = new ShoppingCart();
        cart4.addProducts("Apples", "Chocolate", "Cheese", "Tomatoes", "Cereal");

        ShoppingHistory shoppingHistory = new ShoppingHistory();
        shoppingHistory.addCarts(cart1, cart2, cart3, cart4);
        shoppingHistory.displayHistory();

        System.out.println("The most frequently purchased items in the shopping history: " + shoppingHistory.getTopKFrequentItems(4));
    }
}
