package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public interface QueryPrototype {
        QueryTemplate copy();
    }

    public static class QueryTemplate implements QueryPrototype {
        private final String table;
        private final String filter;

        public QueryTemplate(String table, String filter) {
            this.table = table;
            this.filter = filter;
        }

        public QueryTemplate copy() { return new QueryTemplate(table, filter); }
        public QueryTemplate withFilter(String newFilter) { return new QueryTemplate(table, newFilter); }
        public String sql() { return "SELECT * FROM " + table + " WHERE " + filter; }
    }
}
