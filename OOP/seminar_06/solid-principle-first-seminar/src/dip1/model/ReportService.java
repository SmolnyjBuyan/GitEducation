package dip1.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReportService {
    private Report report;
    private PrintOut printOut;

    public ReportService(Report report, PrintOut printOut) {
        this.report = report;
        this.printOut = printOut;
    }

    // calculate report data
    public void calculate(){
        report.getItems().add(new ReportItem("First", (float)5));
        report.getItems().add(new ReportItem("Second", (float)6));
    }

    public void output(){
        printOut.output(report.getItems());
    }

    public void add(ReportItem... items){
        this.report.getItems().addAll(Arrays.asList(items));
    }
}
