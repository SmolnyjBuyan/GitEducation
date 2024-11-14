import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Employee {
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private String position;
    private int salary;
    private long phoneNumber;

    public Employee(String lastName, String firstName, String middleName,
                    LocalDate birthDate, String position, int salary, long phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.position = position;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
    }

    public void info() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthDate=" + birthDate +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    public boolean compare(LocalDate date1, LocalDate date2) {
        return date1.equals(date2);
    }

    public boolean compare(String date1, String date2) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.US);

        try {
            LocalDate lDate1 = LocalDate.parse(date1, dateTimeFormatter);
            LocalDate lDate2 = LocalDate.parse(date2, dateTimeFormatter);
            return lDate1.equals(lDate2);
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
