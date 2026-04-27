package pattern;

public class ConcreteBuilder implements Builder {
    private final Product product = new Product();

    public void buildHeader() { product.setHeader("reporte: encabezado"); }
    public void buildBody() { product.setBody("reporte: contenido principal"); }
    public void buildFooter() { product.setFooter("reporte: cierre"); }
    public Product result() { return product; }
}
