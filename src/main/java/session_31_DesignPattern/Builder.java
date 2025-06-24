package session_31_DesignPattern;

import java.util.ArrayList;
import java.util.List;

class Pizza {
    private String blat;
    private String sos;
    private List<String> toppings;

    public static class PizzaBuilder {
        private Pizza pizza;

        public PizzaBuilder() {
            pizza = new Pizza();
            pizza.toppings = new ArrayList<>();
        }

        public PizzaBuilder blat(String blat) {
            pizza.blat = blat;
            return this;
        }

        public PizzaBuilder sos(String sos) {
            pizza.sos = sos;
            return this;
        }

        public PizzaBuilder addTopping(String topping) {
            pizza.toppings.add(topping);
            return this;
        }

        public Pizza build() {
            return pizza;
        }
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "blat='" + blat + '\'' +
                ", sos='" + sos + '\'' +
                ", toppings=" + toppings +
                '}';
    }
}

class PizzaB {
    private String blat;
    private String sos;
    private List<String> toppings;

    public PizzaB withBlat(String blat) {
        this.blat = blat;
        return this;
    }

    public PizzaB withSos(String sos) {
        this.sos = sos;
        return this;
    }

    public PizzaB withTopping(String topping) {
        if (toppings == null) {
            toppings = new ArrayList<>();
        }

        toppings.add(topping);
        return this;
    }

    @Override
    public String toString() {
        return "PizzaB{" +
                "blat='" + blat + '\'' +
                ", sos='" + sos + '\'' +
                ", toppings=" + toppings +
                '}';
    }
}

public class Builder {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder()
                .blat("pufos")
                .sos("rosii")
                .addTopping("ardei iuti")
                .addTopping("para")
                .build();
        System.out.println(pizza);

        PizzaB pizzaB = new PizzaB()
                .withBlat("subtire")
                .withSos("rosii")
                .withTopping("mozarella")
                .withTopping("pui")
                .withTopping("porumb");

        System.out.println(pizzaB);
    }
}