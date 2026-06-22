package pattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class PurchaseOrder {
        private final String buyer;
        private final List<String> items;
        private final double discount;
        private final String shippingMethod;

        private PurchaseOrder(Builder builder) {
            this.buyer = builder.buyer;
            this.items = Collections.unmodifiableList(new ArrayList<>(builder.items));
            this.discount = builder.discount;
            this.shippingMethod = builder.shippingMethod;
        }

        public double total() {
            return items.size() * 100.0 * (1.0 - discount);
        }

        public String describe() {
            return buyer + " items=" + items + " despacho=" + shippingMethod + " total=" + total();
        }

        public static Builder builder(String buyer) {
            return new Builder(buyer);
        }

        public static class Builder {
            private final String buyer;
            private final List<String> items = new ArrayList<>();
            private double discount;
            private String shippingMethod = "retiro";

            private Builder(String buyer) {
                this.buyer = buyer;
            }

            public Builder addItem(String sku) {
                items.add(sku);
                return this;
            }

            public Builder discount(double discount) {
                this.discount = discount;
                return this;
            }

            public Builder shippingMethod(String shippingMethod) {
                this.shippingMethod = shippingMethod;
                return this;
            }

            public PurchaseOrder build() {
                if (buyer == null || buyer.isBlank()) {
                    throw new IllegalStateException("buyer es obligatorio");
                }
                if (items.isEmpty()) {
                    throw new IllegalStateException("la orden requiere al menos un item");
                }
                if (discount < 0 || discount >= 1) {
                    throw new IllegalStateException("descuento invalido");
                }
                return new PurchaseOrder(this);
            }
        }
    }
}
