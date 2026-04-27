package pattern;

import java.util.HashMap;
import java.util.Map;

public class CachingReportProxy implements ReportService {
    private final RemoteReportService remote = new RemoteReportService();
    private final Map<String, String> cache = new HashMap<>();

    public String fetchReport(String id) {
        return cache.computeIfAbsent(id, remote::fetchReport);
    }
}
