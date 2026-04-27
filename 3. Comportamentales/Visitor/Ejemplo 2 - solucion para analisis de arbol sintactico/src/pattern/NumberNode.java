package pattern;

public class NumberNode implements AstNode {
    private final int value;
    public NumberNode(int value) { this.value = value; }
    public int value() { return value; }
    public void accept(AstVisitor visitor) { visitor.visit(this); }
}
