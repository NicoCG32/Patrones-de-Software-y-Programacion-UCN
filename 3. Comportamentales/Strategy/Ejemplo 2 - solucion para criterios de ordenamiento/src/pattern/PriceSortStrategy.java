package pattern;

import java.util.Comparator;
import java.util.List;

public class PriceSortStrategy implements SortStrategy {
    public void sort(List<Product> products) { products.sort(Comparator.comparingDouble(p -> p.price)); }
}
