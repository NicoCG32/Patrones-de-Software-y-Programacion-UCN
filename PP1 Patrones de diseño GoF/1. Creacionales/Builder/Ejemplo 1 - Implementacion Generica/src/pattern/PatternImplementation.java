package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public interface Builder {
        void buildHeader();
        void buildBody();
        void buildFooter();
        Product result();
    }

    public static class ConcreteBuilder implements Builder {
        private final Product product = new Product();

        public void buildHeader() { product.setHeader("reporte: encabezado"); }
        public void buildBody() { product.setBody("reporte: contenido principal"); }
        public void buildFooter() { product.setFooter("reporte: cierre"); }
        public Product result() { return product; }
    }

    public static class Director {
        public Product construct(Builder builder) {
            builder.buildHeader();
            builder.buildBody();
            builder.buildFooter();
            return builder.result();
        }
    }

    public static class Product {
        private String header;
        private String body;
        private String footer;

        public void setHeader(String header) { this.header = header; }
        public void setBody(String body) { this.body = body; }
        public void setFooter(String footer) { this.footer = footer; }

        public String toString() { return header + " | " + body + " | " + footer; }
    }
}
