package pattern;

public class SecondResponsibility extends Decorator {
    public SecondResponsibility(Component wrapped) { super(wrapped); }
    public String operation() { return "auditado(" + wrapped.operation() + ")"; }
}
