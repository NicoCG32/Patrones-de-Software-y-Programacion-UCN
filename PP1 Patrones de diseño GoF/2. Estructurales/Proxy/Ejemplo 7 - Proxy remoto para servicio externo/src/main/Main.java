package main;

import static pattern.PatternImplementation.*;

public class Main {

        public static void main(String[] args) {
            CurrencyService service = new CurrencyRemoteProxy();
            System.out.println(service.convertUsdToClp(20.0));
        }

}
