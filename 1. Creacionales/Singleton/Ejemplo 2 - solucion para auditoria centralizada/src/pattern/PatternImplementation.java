package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static final class AuditLog {
        private static final AuditLog INSTANCE = new AuditLog();
        private int sequence;

        private AuditLog() { }
        public static AuditLog getInstance() { return INSTANCE; }

        public void record(String event) {
            sequence++;
            System.out.println("AUD-" + sequence + ": " + event);
        }
    }
}
