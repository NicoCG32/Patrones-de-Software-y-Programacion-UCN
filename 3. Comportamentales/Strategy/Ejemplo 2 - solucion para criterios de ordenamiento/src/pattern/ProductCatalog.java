package pattern;

import java.util.List;

public class ProductCatalog {
    private SortStrategy strategy;
    public ProductCatalog(SortStrategy strategy) { this.strategy = strategy; }
    public void setStrategy(SortStrategy strategy) { this.strategy = strategy; }
    public void show(List<Product> products) { strategy.sort(products); products.forEach(System.out::println); }
}
