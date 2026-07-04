package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static final class SharedService {
        private static final SharedService INSTANCE = new SharedService();
        private int uses;

        private SharedService() { }

        public static SharedService getInstance() { return INSTANCE; }

        public void use(String client) {
            uses++;
            System.out.println("configuracion global usado por " + client + ". usos=" + uses);
        }
    }
}
