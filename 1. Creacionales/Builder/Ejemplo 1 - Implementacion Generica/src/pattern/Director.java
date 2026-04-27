package pattern;

public class Director {
    public Product construct(Builder builder) {
        builder.buildHeader();
        builder.buildBody();
        builder.buildFooter();
        return builder.result();
    }
}
