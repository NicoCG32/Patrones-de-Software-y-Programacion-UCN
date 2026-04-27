package pattern;

public class MySqlCommand implements DatabaseCommand {
    public String execute(String sql) { return "MySQL ejecuta: " + sql; }
}
