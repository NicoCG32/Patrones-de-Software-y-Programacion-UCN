package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public interface Document {
        void open(String userRole);
    }

    public static class ProtectedDocumentProxy implements Document {
        private final SecureDocument document = new SecureDocument();

        public void open(String userRole) {
            if (!"ADMIN".equals(userRole)) {
                System.out.println("Acceso denegado para " + userRole);
                return;
            }
            document.open(userRole);
        }
    }

    public static class SecureDocument implements Document {
        public void open(String userRole) { System.out.println("Documento sensible abierto para " + userRole); }
    }
}
