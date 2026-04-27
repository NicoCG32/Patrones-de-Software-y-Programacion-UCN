package pattern;

public class Product {
    public final String name;
    public final double price;
    public final int relevance;

    public Product(String name, double price, int relevance) {
        this.name = name;
        this.price = price;
        this.relevance = relevance;
    }
    public String toString() { return name + " $" + price + " rel=" + relevance; }
}
