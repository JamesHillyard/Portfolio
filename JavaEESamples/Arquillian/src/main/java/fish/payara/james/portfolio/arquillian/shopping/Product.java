package fish.payara.james.portfolio.arquillian.shopping;

public class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}