package pattern;

public class MySqlDriverFactory implements DatabaseDriverFactory {
    public DatabaseConnection createConnection() { return new MySqlConnection(); }
    public DatabaseCommand createCommand() { return new MySqlCommand(); }
}
