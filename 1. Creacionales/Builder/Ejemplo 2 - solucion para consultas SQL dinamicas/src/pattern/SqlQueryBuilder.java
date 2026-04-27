package pattern;

public class SqlQueryBuilder {
    private String select = "*";
    private String table;
    private String where = "1=1";
    private String order = "id";

    public SqlQueryBuilder select(String columns) { select = columns; return this; }
    public SqlQueryBuilder from(String table) { this.table = table; return this; }
    public SqlQueryBuilder where(String condition) { where = condition; return this; }
    public SqlQueryBuilder orderBy(String column) { order = column; return this; }

    public SqlQuery build() {
        if (table == null) throw new IllegalStateException("La tabla es obligatoria");
        return new SqlQuery("SELECT " + select + " FROM " + table + " WHERE " + where + " ORDER BY " + order);
    }
}
