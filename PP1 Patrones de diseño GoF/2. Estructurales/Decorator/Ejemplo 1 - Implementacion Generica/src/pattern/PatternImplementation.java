package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class BaseComponent implements Component {
        public String operation() { return "mensaje"; }
    }

    public interface Component {
        String operation();
    }

    public static abstract class Decorator implements Component {
        protected final Component wrapped;

        protected Decorator(Component wrapped) { this.wrapped = wrapped; }
    }

    public static class FirstResponsibility extends Decorator {
        public FirstResponsibility(Component wrapped) { super(wrapped); }
        public String operation() { return "validado(" + wrapped.operation() + ")"; }
    }

    public static class SecondResponsibility extends Decorator {
        public SecondResponsibility(Component wrapped) { super(wrapped); }
        public String operation() { return "auditado(" + wrapped.operation() + ")"; }
    }
}
