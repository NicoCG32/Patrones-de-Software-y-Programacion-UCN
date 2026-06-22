package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class AuditVisitor implements ItemVisitor {
        public void visit(Book book) { System.out.println("Audita libro: " + book.title()); }
        public void visit(SoftwareLicense license) { System.out.println("Audita licencia: " + license.key()); }
    }

    public static class Book implements Item {
        public String title() { return "Patrones GoF"; }
        public void accept(ItemVisitor visitor) { visitor.visit(this); }
    }

    public interface Item {
        void accept(ItemVisitor visitor);
    }

    public interface ItemVisitor {
        void visit(Book book);
        void visit(SoftwareLicense license);
    }

    public static class SoftwareLicense implements Item {
        public String key() { return "LIC-2026"; }
        public void accept(ItemVisitor visitor) { visitor.visit(this); }
    }
}
