package pattern;

public class AuditVisitor implements ItemVisitor {
    public void visit(Book book) { System.out.println("Audita libro: " + book.title()); }
    public void visit(SoftwareLicense license) { System.out.println("Audita licencia: " + license.key()); }
}
