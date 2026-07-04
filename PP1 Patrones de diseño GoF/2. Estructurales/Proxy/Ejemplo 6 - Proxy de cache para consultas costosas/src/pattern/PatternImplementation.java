package pattern;

import java.util.HashMap;
import java.util.Map;

public final class PatternImplementation {
    private PatternImplementation() { }

    public interface ReportRepository {
        String findById(String id);
    }

    public static class DatabaseReportRepository implements ReportRepository {
        public String findById(String id) {
            System.out.println("Consultando base de datos para " + id);
            return "reporte-" + id;
        }
    }

    public static class CachedReportProxy implements ReportRepository {
        private final ReportRepository realRepository;
        private final Map<String, String> cache = new HashMap<>();

        public CachedReportProxy(ReportRepository realRepository) {
            this.realRepository = realRepository;
        }

        public String findById(String id) {
            return cache.computeIfAbsent(id, realRepository::findById);
        }
    }
}
