package pattern;

public interface ItemVisitor {
    void visit(Book book);
    void visit(SoftwareLicense license);
}
