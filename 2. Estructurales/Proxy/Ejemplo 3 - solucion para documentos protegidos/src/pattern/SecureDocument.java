package pattern;

public class SecureDocument implements Document {
    public void open(String userRole) { System.out.println("Documento sensible abierto para " + userRole); }
}
