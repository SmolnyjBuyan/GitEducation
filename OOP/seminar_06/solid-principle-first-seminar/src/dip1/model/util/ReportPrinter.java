package dip1.model.util;

import dip1.model.PrintOut;
import dip1.model.ReportItem;

import java.io.PrintWriter;
import java.util.List;

public class ReportPrinter extends PrintOut {

    @Override
    public void output(List<ReportItem> items) {
        System.out.println("Output to printer");
        for (ReportItem item : items) {
            System.out.format("printer %s - %f \n\r", item.getDescription(), item.getAmount());
        }
    }
}
