import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        LocalDate sample1 = LocalDate.of(1993, 10, 30);
        LocalDate sample2 = LocalDate.of(1993, 10, 29);

        Employee andrey = new Employee(
                "Kotov",
                "Andrey",
                "Andreevich",
                LocalDate.of(1993, 10, 30),
                "Developer",
                100_000,
                89997778866L);

        Employee vasiliy = new Employee(
                "Mitinskiy",
                "Vasiliy",
                "Vasilievich",
                LocalDate.of(1990, 4, 10),
                "Developer",
                150_000,
                89996668866L);

        Employee dmitriy = new Employee(
                "Stolyarenko",
                "Dmitriy",
                "Aleksandrovich",
                LocalDate.of(1993, 2, 26),
                "Developer",
                250_000,
                89995465566L);

        Employee oleg = new Employee(
                "Prokopenko",
                "Oleg",
                "Aleksandrovich",
                LocalDate.of(1970, 3, 6),
                "Journalist",
                150_000,
                89996668866L);

        Employee kirill = new Employee(
                "Ivanov",
                "Kirill",
                "Anatolyevich",
                LocalDate.of(1968, 1, 15),
                "Editor",
                80_000,
                89996668866L);

        andrey.info();
        Employee[] employees = {andrey, vasiliy, dmitriy, oleg, kirill};

        System.out.println(andrey.compare(sample1, sample2));
        System.out.println(andrey.compare("1993-10-30", "1993-10-30"));
    }
}