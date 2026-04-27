package pattern;

public class PostgresCommand implements DatabaseCommand {
    public String execute(String sql) { return "PostgreSQL ejecuta: " + sql; }
}
