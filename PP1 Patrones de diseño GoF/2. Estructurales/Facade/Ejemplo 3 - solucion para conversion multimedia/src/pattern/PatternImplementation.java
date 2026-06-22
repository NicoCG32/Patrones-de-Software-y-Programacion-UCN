package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class FilterEngine {
        public void apply(String filter) { System.out.println("Aplicando filtro " + filter); }
    }

    public static class MediaConversionFacade {
        private final VideoDecoder decoder = new VideoDecoder();
        private final FilterEngine filters = new FilterEngine();
        private final VideoEncoder encoder = new VideoEncoder();

        public void convert(String file, String format) {
            decoder.decode(file);
            filters.apply("color-correction");
            encoder.encode(format);
        }
    }

    public static class VideoDecoder {
        public void decode(String file) { System.out.println("Decodificando " + file); }
    }

    public static class VideoEncoder {
        public void encode(String format) { System.out.println("Exportando como " + format); }
    }
}
