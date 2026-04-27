package pattern;

public class ExternalCrmApi {
    public String getCustomerXml(String id) { return "<customer><id>" + id + "</id><name>Ada Lovelace</name></customer>"; }
}
