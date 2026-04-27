package pattern;

public class ProtectedDocumentProxy implements Document {
    private final SecureDocument document = new SecureDocument();

    public void open(String userRole) {
        if (!"ADMIN".equals(userRole)) {
            System.out.println("Acceso denegado para " + userRole);
            return;
        }
        document.open(userRole);
    }
}
