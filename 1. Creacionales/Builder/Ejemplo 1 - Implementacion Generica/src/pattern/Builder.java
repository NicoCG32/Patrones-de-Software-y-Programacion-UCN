package pattern;

public interface Builder {
    void buildHeader();
    void buildBody();
    void buildFooter();
    Product result();
}
