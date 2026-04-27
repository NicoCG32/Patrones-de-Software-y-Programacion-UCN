package pattern;

public class Client {
    private final Primary primary;
    private final Secondary secondary;

    public Client(FamilyFactory factory) {
        primary = factory.createPrimary();
        secondary = factory.createSecondary();
    }

    public void run() {
        System.out.println(primary.describe());
        System.out.println(secondary.describe());
    }
}
