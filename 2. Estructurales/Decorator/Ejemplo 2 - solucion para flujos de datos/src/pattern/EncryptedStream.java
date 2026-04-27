package pattern;

public class EncryptedStream extends StreamDecorator {
    public EncryptedStream(DataStream wrapped) { super(wrapped); }
    public String read() { return "decrypt(" + wrapped.read() + ")"; }
}
