package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class CrmCustomerAdapter implements CustomerProvider {
        private final ExternalCrmApi api;

        public CrmCustomerAdapter(ExternalCrmApi api) { this.api = api; }

        public Customer findCustomer(String id) {
            String xml = api.getCustomerXml(id);
            String name = xml.replaceAll(".*<name>|</name>.*", "");
            return new Customer(id, name);
        }
    }

    public static class Customer {
        private final String id;
        private final String name;

        public Customer(String id, String name) { this.id = id; this.name = name; }
        public String toString() { return id + " - " + name; }
    }

    public interface CustomerProvider {
        Customer findCustomer(String id);
    }

    public static class ExternalCrmApi {
        public String getCustomerXml(String id) { return "<customer><id>" + id + "</id><name>Ada Lovelace</name></customer>"; }
    }
}
