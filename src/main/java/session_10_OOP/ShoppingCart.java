package session_10_OOP;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> products;
    private int id;

    static int counter = 0;

    public ShoppingCart(){
        this.products = new ArrayList<>();
        this.id = ++counter;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void addDiscount(){
        for (Product p : products){
            p.setPrice(p.getPrice() * 0.9);
        }
    }

    public void displayCart(){
        System.out.println("Cart id: " + id);

        for (Product product : products){
            System.out.println(product);
        }
    }
}

class Product{
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return id + ": " + name + ", $" + price;
    }
}

class MainShopping{
    public static void main(String[] args) {
        Product product1 = new Product(1, "Lenovo", 1200.0);
        Product product2 = new Product(2, "Mac", 2000);
        Product product3 = new Product(3, "Iphone", 1600);

        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);

        ShoppingCart cart1 = new ShoppingCart();
        cart1.addProduct(product1);
        cart1.addProduct(product3);

        ShoppingCart cart2 = new ShoppingCart();
        cart2.addProduct(product2);

        System.out.println("Cart1: ");
        cart1.displayCart();

        System.out.println("Cart2: ");
        cart2.displayCart();

        ShoppingCart cart3 = new ShoppingCart();
        cart3.addProduct(product1);
        cart3.addProduct(product2);
        cart3.addProduct(product3);

        cart3.addDiscount();

        System.out.println("Cart3: ");
        cart3.displayCart();
    }
}
