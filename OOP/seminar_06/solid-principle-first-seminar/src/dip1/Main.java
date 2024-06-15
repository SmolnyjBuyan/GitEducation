package dip1;

import dip1.model.Report;
import dip1.model.ReportItem;
import dip1.model.ReportService;
import dip1.model.util.ReportConsole;
import dip1.model.util.ReportPrinter;
import logger.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger log = Log.log(Main.class.getName());
    public static void main(String[] args) {
        log.log(Level.INFO, "Method main in model package started");

        List<ReportItem> reports = new ArrayList<>();
        reports.add(new ReportItem("Item1", 2.8F));
        reports.add(new ReportItem("Item2", 3.6F));
        Report report = new Report(reports);
        ReportService reportService = new ReportService(report,new ReportPrinter());
        ReportService reportService2 = new ReportService(report,new ReportConsole());

        reportService.output();
        reportService2.output();
    }
}
