package session_16_Hash.Homework;

public class Address {
    private String city;
    private String state;
    private String country;
    private String street;
    private String postalCode;

    public Address(String city, String state, String country, String street, String postalCode) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.street = street;
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "[" + city + ", " + country + "]";
    }
}

class TestAddress{
    public static void main(String[] args) {
        Address address = new Address(
                "New York",
                "NY",
                "USA",
                "123 Main Street",
                "10001"
        );

        System.out.println(address);
    }
}
