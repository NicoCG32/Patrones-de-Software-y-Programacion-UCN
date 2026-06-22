package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public interface CurrencyService {
        double convertUsdToClp(double usd);
    }

    public static class RemoteCurrencyService implements CurrencyService {
        public double convertUsdToClp(double usd) {
            return usd * 950.0;
        }
    }

    public static class CurrencyRemoteProxy implements CurrencyService {
        private final RemoteCurrencyService remote = new RemoteCurrencyService();

        public double convertUsdToClp(double usd) {
            System.out.println("Serializando solicitud y llamando endpoint remoto");
            return remote.convertUsdToClp(usd);
        }
    }
}
