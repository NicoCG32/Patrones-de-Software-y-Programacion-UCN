package pattern;

public final class SharedService {
    private static final SharedService INSTANCE = new SharedService();
    private int uses;

    private SharedService() { }

    public static SharedService getInstance() { return INSTANCE; }

    public void use(String client) {
        uses++;
        System.out.println("configuracion global usado por " + client + ". usos=" + uses);
    }
}
