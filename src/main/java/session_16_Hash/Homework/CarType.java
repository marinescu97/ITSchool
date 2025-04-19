package session_16_Hash.Homework;

public enum CarType {
    SEDAN("Toyota", 25000),
    SUV("Ford", 35000),
    TRUCK("Chevrolet", 40000),
    COUPE("BMW", 45000),
    HATCHBACK("Volkswagen", 22000);

    private final String manufacturer;
    private final int averagePrice;

    // Constructor
    CarType(String manufacturer, int averagePrice) {
        this.manufacturer = manufacturer;
        this.averagePrice = averagePrice;
    }

    @Override
    public String toString() {
        return String.format("%s -> %d", manufacturer, averagePrice);
    }
}

class TestCar {
    public static void main(String[] args) {
        for (CarType carType : CarType.values()) {
            System.out.println(carType);
        }
    }
}
