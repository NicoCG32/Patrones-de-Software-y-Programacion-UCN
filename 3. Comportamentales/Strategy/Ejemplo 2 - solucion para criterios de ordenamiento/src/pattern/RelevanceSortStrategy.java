package pattern;

import java.util.Comparator;
import java.util.List;

public class RelevanceSortStrategy implements SortStrategy {
    public void sort(List<Product> products) { products.sort(Comparator.comparingInt((Product p) -> p.relevance).reversed()); }
}
