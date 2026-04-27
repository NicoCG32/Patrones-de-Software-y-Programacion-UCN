package pattern;

public class ApplicationFacade {
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
