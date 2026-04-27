package pattern;

public class CrmCustomerAdapter implements CustomerProvider {
    private final ExternalCrmApi api;

    public CrmCustomerAdapter(ExternalCrmApi api) { this.api = api; }

    public Customer findCustomer(String id) {
        String xml = api.getCustomerXml(id);
        String name = xml.replaceAll(".*<name>|</name>.*", "");
        return new Customer(id, name);
    }
}
