package pattern;

public class FirstResponsibility extends Decorator {
    public FirstResponsibility(Component wrapped) { super(wrapped); }
    public String operation() { return "validado(" + wrapped.operation() + ")"; }
}
