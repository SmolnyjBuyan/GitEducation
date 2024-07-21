package showplaces;

public class Showplace{
    private String name;
    private double timeInDays;
    private int rating;

    public Showplace(String name, double timeInDays, int grade) {
        this.name = name;
        this.timeInDays = timeInDays;
        this.rating = grade;
    }

    public String getName() {
        return name;
    }

    public double getTimeInDays() {
        return timeInDays;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "showplaces.Showplace{" +
                "name='" + name + '\'' +
                ", timeInDays=" + timeInDays +
                ", rating=" + rating +
                '}';
    }
}
