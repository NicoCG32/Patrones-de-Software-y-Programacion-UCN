package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class BufferedStream extends StreamDecorator {
        public BufferedStream(DataStream wrapped) { super(wrapped); }
        public String read() { return "buffer(" + wrapped.read() + ")"; }
    }

    public interface DataStream {
        String read();
    }

    public static class EncryptedStream extends StreamDecorator {
        public EncryptedStream(DataStream wrapped) { super(wrapped); }
        public String read() { return "decrypt(" + wrapped.read() + ")"; }
    }

    public static class FileStream implements DataStream {
        public String read() { return "bloque de archivo"; }
    }

    public static abstract class StreamDecorator implements DataStream {
        protected final DataStream wrapped;
        protected StreamDecorator(DataStream wrapped) { this.wrapped = wrapped; }
    }
}
