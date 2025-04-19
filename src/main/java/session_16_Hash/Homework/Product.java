package session_16_Hash.Homework;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o){
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return id == product.id;
    }
    
    @Override
    public int hashCode(){
        return Objects.hashCode(id);
    }
}

class ProductTest{
    public static void main(String[] args) {
        Product product1 = new Product(4, "Milk", 5.5);
        Product product2 = new Product(4, "Orange", 5.5);
        Product product3 = new Product(2, "Milk", 6d);

        System.out.println("product1 equals to product2? " + product1.equals(product2));
        System.out.println("product1 equals to product3? " + product1.equals(product3));

        System.out.println("product1 hashcode: " + product1.hashCode());
        System.out.println("product2 hashcode: " + product2.hashCode());
        System.out.println("product3 hashcode: " + product3.hashCode());
    }
}
