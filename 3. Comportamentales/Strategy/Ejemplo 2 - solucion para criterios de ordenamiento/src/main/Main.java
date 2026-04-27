package main;

import pattern.*;

public class Main {
    public static void main(String[] args) {
    java.util.List<Product> products = new java.util.ArrayList<>();
    products.add(new Product("monitor", 210, 5));
    products.add(new Product("teclado", 60, 9));
    ProductCatalog catalog = new ProductCatalog(new PriceSortStrategy());
    catalog.show(products);
}
}
