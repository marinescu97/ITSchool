package session_15_javaCollections.Homework.Challenge;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<String, Integer> products;

    public ShoppingCart() {
        this.products = new HashMap<>();
    }

    public void addProduct(String product){
        products.put(product, products.getOrDefault(product, 0) + 1);
    }

    public void addProducts(String... products){
        for (String product : products){
            addProduct(product);
        }
    }

    public Map<String, Integer> getProducts() {
        return products;
    }
}
