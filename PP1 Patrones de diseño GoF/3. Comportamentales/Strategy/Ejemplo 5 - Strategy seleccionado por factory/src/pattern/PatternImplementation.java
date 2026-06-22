package pattern;

import java.util.HashMap;
import java.util.Map;

public final class PatternImplementation {
    private PatternImplementation() { }

    public interface PricingStrategy {
        double finalPrice(double basePrice);
    }

    public static class StandardPricing implements PricingStrategy {
        public double finalPrice(double basePrice) {
            return basePrice;
        }
    }

    public static class VipPricing implements PricingStrategy {
        public double finalPrice(double basePrice) {
            return basePrice * 0.85;
        }
    }

    public static class PriceCalculator {
        private final PricingStrategy strategy;

        public PriceCalculator(PricingStrategy strategy) {
            this.strategy = strategy;
        }

        public double calculate(double basePrice) {
            return strategy.finalPrice(basePrice);
        }
    }

    public static class PricingStrategyFactory {
        private final Map<String, PricingStrategy> strategies = new HashMap<>();

        public PricingStrategyFactory() {
            strategies.put("standard", new StandardPricing());
            strategies.put("vip", new VipPricing());
        }

        public PricingStrategy fromCode(String code) {
            PricingStrategy strategy = strategies.get(code);
            if (strategy == null) {
                throw new IllegalArgumentException("Estrategia desconocida: " + code);
            }
            return strategy;
        }
    }
}
