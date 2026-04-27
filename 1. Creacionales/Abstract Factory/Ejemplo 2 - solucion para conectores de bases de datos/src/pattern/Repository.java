package pattern;

public class Repository {
    private final DatabaseConnection connection;
    private final DatabaseCommand command;

    public Repository(DatabaseDriverFactory factory) {
        connection = factory.createConnection();
        command = factory.createCommand();
    }

    public void findOrders() {
        System.out.println(connection.open());
        System.out.println(command.execute("select * from orders"));
    }
}
