package pattern;

public interface DatabaseDriverFactory {
    DatabaseConnection createConnection();
    DatabaseCommand createCommand();
}
