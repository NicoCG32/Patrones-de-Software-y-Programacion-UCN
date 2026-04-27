package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public interface DatabaseCommand {
        String execute(String sql);
    }

    public interface DatabaseConnection {
        String open();
    }

    public interface DatabaseDriverFactory {
        DatabaseConnection createConnection();
        DatabaseCommand createCommand();
    }

    public static class MySqlCommand implements DatabaseCommand {
        public String execute(String sql) { return "MySQL ejecuta: " + sql; }
    }

    public static class MySqlConnection implements DatabaseConnection {
        public String open() { return "Conexion MySQL abierta"; }
    }

    public static class MySqlDriverFactory implements DatabaseDriverFactory {
        public DatabaseConnection createConnection() { return new MySqlConnection(); }
        public DatabaseCommand createCommand() { return new MySqlCommand(); }
    }

    public static class PostgresCommand implements DatabaseCommand {
        public String execute(String sql) { return "PostgreSQL ejecuta: " + sql; }
    }

    public static class PostgresConnection implements DatabaseConnection {
        public String open() { return "Conexion PostgreSQL abierta"; }
    }

    public static class PostgresDriverFactory implements DatabaseDriverFactory {
        public DatabaseConnection createConnection() { return new PostgresConnection(); }
        public DatabaseCommand createCommand() { return new PostgresCommand(); }
    }

    public static class Repository {
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
}
