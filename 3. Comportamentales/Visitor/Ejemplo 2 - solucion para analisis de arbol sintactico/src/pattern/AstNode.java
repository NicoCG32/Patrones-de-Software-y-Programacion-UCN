package pattern;

public interface AstNode {
    void accept(AstVisitor visitor);
}
