package main;

import static pattern.PatternImplementation.*;
public class Main {
    public static void main(String[] args) {
    ReportService service = new CachingReportProxy();
    System.out.println(service.fetchReport("R-1"));
    System.out.println(service.fetchReport("R-1"));
}
}
