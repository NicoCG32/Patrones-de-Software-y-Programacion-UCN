package pattern;

public class BufferedStream extends StreamDecorator {
    public BufferedStream(DataStream wrapped) { super(wrapped); }
    public String read() { return "buffer(" + wrapped.read() + ")"; }
}
