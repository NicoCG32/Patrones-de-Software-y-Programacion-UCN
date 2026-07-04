package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class ApplicationFacade {
        private final ConfigurationLoader config = new ConfigurationLoader();
        private final Logger logger = new Logger();
        private final Database database = new Database();

        public void start() {
            config.load();
            logger.start();
            database.connect();
            System.out.println("Aplicacion lista");
        }
    }

    public static class ConfigurationLoader {
        public void load() { System.out.println("Configuracion cargada"); }
    }

    public static class Database {
        public void connect() { System.out.println("Base de datos conectada"); }
    }

    public static class Logger {
        public void start() { System.out.println("Logger iniciado"); }
    }
}
