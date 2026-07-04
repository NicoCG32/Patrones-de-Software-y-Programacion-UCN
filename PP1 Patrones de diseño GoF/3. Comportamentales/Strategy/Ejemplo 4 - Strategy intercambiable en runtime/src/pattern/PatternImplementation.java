package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public interface FilterStrategy {
        String apply(String image);
    }

    public static class GrayscaleFilter implements FilterStrategy {
        public String apply(String image) {
            return "gris(" + image + ")";
        }
    }

    public static class ContrastFilter implements FilterStrategy {
        public String apply(String image) {
            return "contraste(" + image + ")";
        }
    }

    public static class ImageEditor {
        private FilterStrategy filter;

        public ImageEditor(FilterStrategy filter) {
            this.filter = filter;
        }

        public void setFilter(FilterStrategy filter) {
            this.filter = filter;
        }

        public String render(String image) {
            return filter.apply(image);
        }
    }
}
