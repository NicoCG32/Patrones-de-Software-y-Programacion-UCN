package pattern;

public interface AstVisitor {
    void visit(NumberNode node);
    void visit(AddNode node);
}
