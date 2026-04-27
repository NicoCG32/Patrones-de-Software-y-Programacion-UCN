package pattern;

public class MediaConversionFacade {
    private final VideoDecoder decoder = new VideoDecoder();
    private final FilterEngine filters = new FilterEngine();
    private final VideoEncoder encoder = new VideoEncoder();

    public void convert(String file, String format) {
        decoder.decode(file);
        filters.apply("color-correction");
        encoder.encode(format);
    }
}
