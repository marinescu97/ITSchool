package session_15_javaCollections.Homework.Challenge;

import java.util.*;

public class ShoppingHistory {
    private final Map<String, Integer> carts;

    public ShoppingHistory() {
        carts = new HashMap<>();
    }

    public void addCart(ShoppingCart cart){
        for (Map.Entry<String, Integer> entry : cart.getProducts().entrySet()){
            String productId = entry.getKey();
            int quantity = entry.getValue();
            carts.put(productId, carts.getOrDefault(productId, 0) + quantity);
        }
    }

    public void addCarts(ShoppingCart... carts){
        for (ShoppingCart cart : carts){
            addCart(cart);
        }
    }

    public List<String> getTopKFrequentItems(int k) {
        PriorityQueue<Map.Entry<String, Integer>> sortedProducts = new PriorityQueue<>(
                (a, b) -> b.getValue().compareTo(a.getValue())
        );

        sortedProducts.addAll(carts.entrySet());

        List<String> result = new ArrayList<>();
        int lastFrequency = 0;

        while (!sortedProducts.isEmpty()) {
            Map.Entry<String, Integer> entry = sortedProducts.poll();
            if (result.size() < k) {
                result.add(entry.getKey());
                lastFrequency = entry.getValue();
            } else if (entry.getValue() == lastFrequency) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public void displayHistory(){
        for (Map.Entry<String, Integer> entry : carts.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
