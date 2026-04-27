package pattern;

public class RemoteReportService implements ReportService {
    public String fetchReport(String id) { return "Reporte remoto " + id; }
}
