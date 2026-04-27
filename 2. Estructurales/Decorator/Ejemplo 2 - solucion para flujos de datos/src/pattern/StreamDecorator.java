package pattern;

public abstract class StreamDecorator implements DataStream {
    protected final DataStream wrapped;
    protected StreamDecorator(DataStream wrapped) { this.wrapped = wrapped; }
}
