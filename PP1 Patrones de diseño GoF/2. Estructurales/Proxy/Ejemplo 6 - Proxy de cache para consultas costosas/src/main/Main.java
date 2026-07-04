package main;

import static pattern.PatternImplementation.*;

public class Main {

        public static void main(String[] args) {
            ReportRepository repository = new CachedReportProxy(new DatabaseReportRepository());
            System.out.println(repository.findById("R-7"));
            System.out.println(repository.findById("R-7"));
        }

}
