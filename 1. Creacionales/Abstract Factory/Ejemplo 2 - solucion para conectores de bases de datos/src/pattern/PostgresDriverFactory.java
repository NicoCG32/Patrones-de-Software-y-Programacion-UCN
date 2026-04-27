package pattern;

public class PostgresDriverFactory implements DatabaseDriverFactory {
    public DatabaseConnection createConnection() { return new PostgresConnection(); }
    public DatabaseCommand createCommand() { return new PostgresCommand(); }
}
