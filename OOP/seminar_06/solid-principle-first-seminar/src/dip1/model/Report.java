package dip1.model;

import dip1.model.util.ReportPrinter;

import java.util.ArrayList;
import java.util.List;

public class Report{
    private List<ReportItem> items;

    public Report(List<ReportItem> items) {
        this.items = items;
    }

    public List<ReportItem> getItems() {
        return items;
    }
}
