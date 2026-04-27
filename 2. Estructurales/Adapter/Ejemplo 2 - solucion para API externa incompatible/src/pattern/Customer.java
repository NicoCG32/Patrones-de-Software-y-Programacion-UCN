package pattern;

public class Customer {
    private final String id;
    private final String name;

    public Customer(String id, String name) { this.id = id; this.name = name; }
    public String toString() { return id + " - " + name; }
}
