package showplaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShowplacesCell implements Comparable<ShowplacesCell>{
    private List<Showplace> showplaces;
    private double maxDurationInDays;

    public ShowplacesCell(double maxDurationInDays) {
        this.maxDurationInDays = maxDurationInDays;
        showplaces = new ArrayList<>();
    }

    public int getOverallRating() {
        return showplaces.stream().mapToInt(Showplace::getRating).sum();
    }

    public void add(Showplace showplace) {
        if (isFitIn(showplace)) showplaces.add(showplace);
    }

    public void addAll(Showplace... showplaces) {
        if (isFitIn(showplaces)) this.showplaces.addAll(List.of(showplaces));
    }

    protected void addWithoutCheckForFitIn(Showplace showplace) {
        showplaces.add(showplace);
    }

    protected void addAllWithoutCheckForFitIn(Showplace... showplaces) {
        this.showplaces.addAll(List.of(showplaces));
    }

    private boolean isFitIn(Showplace showplace) {
        return showplace.getTimeInDays() <= getRemainingDurationInDays();
    }

    private boolean isFitIn(Showplace... showplaces) {
        return Arrays.stream(showplaces).mapToDouble(Showplace::getTimeInDays).sum() <= getRemainingDurationInDays();
    }

    public double getRemainingDurationInDays() {
        return maxDurationInDays - getCurrentDurationInDays();
    }

    private double getCurrentDurationInDays() {
        return showplaces.stream().mapToDouble(Showplace::getTimeInDays).sum();
    }

    public List<Showplace> getShowplaces() {
        return showplaces;
    }

    public boolean isOverallRatingHigherCompareTo(ShowplacesCell showplacesCell) {
        return this.getOverallRating() > showplacesCell.getOverallRating();
    }

    @Override
    public String toString() {
        return "Cell{" +
                "showplaces=" + showplaces +
                '}';
    }

    @Override
    public int compareTo(ShowplacesCell showplacesCell) {
        if (this.getCurrentDurationInDays() > showplacesCell.getCurrentDurationInDays()) {
            return 1;
        } else if (this.getCurrentDurationInDays() > showplacesCell.getCurrentDurationInDays()) {
            return -1;
        } else {
            return 0;
        }
    }
}
