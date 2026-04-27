package pattern;

public class AddNode implements AstNode {
    private final AstNode left;
    private final AstNode right;
    public AddNode(AstNode left, AstNode right) { this.left = left; this.right = right; }
    public AstNode left() { return left; }
    public AstNode right() { return right; }
    public void accept(AstVisitor visitor) { visitor.visit(this); }
}
