package pattern;

public abstract class Decorator implements Component {
    protected final Component wrapped;

    protected Decorator(Component wrapped) { this.wrapped = wrapped; }
}
