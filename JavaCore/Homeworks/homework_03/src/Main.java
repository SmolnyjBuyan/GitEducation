import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        LocalDate sample1 = LocalDate.of(1993, 10, 30);
        LocalDate sample2 = LocalDate.of(1993, 10, 29);

        System.out.println(compare(sample1, sample2));
        System.out.println(compare("1993-10-30", "1993-10-30"));
    }

    public static boolean compare(LocalDate date1, LocalDate date2) {
        return date1.equals(date2);
    }

    public static boolean compare(String date1, String date2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.US);

        try {
            LocalDate lDate1 = LocalDate.parse(date1, formatter);
            LocalDate lDate2 = LocalDate.parse(date2, formatter);
            return lDate1.equals(lDate2);
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}