package pattern;

import java.util.Comparator;
import java.util.List;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class PriceSortStrategy implements SortStrategy {
        public void sort(List<Product> products) { products.sort(Comparator.comparingDouble(p -> p.price)); }
    }

    public static class Product {
        public final String name;
        public final double price;
        public final int relevance;

        public Product(String name, double price, int relevance) {
            this.name = name;
            this.price = price;
            this.relevance = relevance;
        }
        public String toString() { return name + " $" + price + " rel=" + relevance; }
    }

    public static class ProductCatalog {
        private SortStrategy strategy;
        public ProductCatalog(SortStrategy strategy) { this.strategy = strategy; }
        public void setStrategy(SortStrategy strategy) { this.strategy = strategy; }
        public void show(List<Product> products) { strategy.sort(products); products.forEach(System.out::println); }
    }

    public static class RelevanceSortStrategy implements SortStrategy {
        public void sort(List<Product> products) { products.sort(Comparator.comparingInt((Product p) -> p.relevance).reversed()); }
    }

    public interface SortStrategy {
        void sort(List<Product> products);
    }
}
