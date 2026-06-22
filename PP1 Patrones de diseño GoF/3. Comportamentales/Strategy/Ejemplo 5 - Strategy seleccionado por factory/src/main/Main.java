package main;

import static pattern.PatternImplementation.*;

public class Main {

        public static void main(String[] args) {
            PricingStrategyFactory factory = new PricingStrategyFactory();
            PricingStrategy strategy = factory.fromCode("vip");
            PriceCalculator calculator = new PriceCalculator(strategy);

            System.out.println(calculator.calculate(100.0));
        }

}
