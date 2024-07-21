package showplaces;

import java.util.*;

public class ShowplaceCalculator {
    private ShowplacesCell[][] cells;
    private List<Double> columns;
    private List<Showplace> rows;
    private Set<Showplace> showplaces;
    private int durationInDays;

    public ShowplaceCalculator(int durationInDays, Showplace... showplace) {
        this.showplaces = new LinkedHashSet<>(List.of(showplace));
        this.durationInDays = durationInDays;
        setColumns();
        setRows();
        cells = new ShowplacesCell[rows.size()][columns.size()];
        fillCells();
    }

    private void setRows() {
        rows = new ArrayList<>(showplaces);
    }

    private void setColumns() {
        columns = new ArrayList<>();
        double step = showplaces.stream().mapToDouble(Showplace::getTimeInDays).min().getAsDouble();
        double column = step;
        while (column < durationInDays) {
            columns.add(column);
            column+=step;
        }
        columns.add((double) durationInDays);
    }

    private void fillCells() {
        for (int j = 0; j < columns.size(); j++) {
            cells[0][j] = new ShowplacesCell(columns.get(j));
            cells[0][j].add(rows.getFirst());
        }

        for (int i = 1; i < rows.size(); i++) {
            for (int j = 0; j < columns.size(); j++) {
                cells[i][j] =  new ShowplacesCell(columns.get(j));
                cells[i][j].add(rows.get(i));
                double remainingDuration = cells[i][j].getRemainingDurationInDays();
                if (remainingDuration != 0) {
                    ShowplacesCell cellToMerge = cells[i -1][columns.indexOf(remainingDuration)];
                    cells[i][j].addAllWithoutCheckForFitIn(cellToMerge.getShowplaces().toArray(new Showplace[0]));
                }

                if (cells[i - 1][j].isOverallRatingHigherCompareTo(cells[i][j])) {
                    cells[i][j] = cells[i-1][j];
                }
            }
        }
    }


    public List<Double> getColumns() {
        return columns;
    }

    public List<Showplace> getRows() {
        return rows;
    }

    public void printTable() {
        for (ShowplacesCell[] cell : cells) {
            for (ShowplacesCell showplacesCell : cell) {
                System.out.print(showplacesCell.getOverallRating() + " ");
            }
            System.out.println();
        }
    }
}
