package pattern;

import java.util.HashMap;
import java.util.Map;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class CachingReportProxy implements ReportService {
        private final RemoteReportService remote = new RemoteReportService();
        private final Map<String, String> cache = new HashMap<>();

        public String fetchReport(String id) {
            return cache.computeIfAbsent(id, remote::fetchReport);
        }
    }

    public static class RemoteReportService implements ReportService {
        public String fetchReport(String id) { return "Reporte remoto " + id; }
    }

    public interface ReportService {
        String fetchReport(String id);
    }
}
