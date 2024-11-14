import java.time.LocalDate;
import java.util.Arrays;

public class SuperVisor extends Employee{
    public SuperVisor(String lastName, String firstName, String middleName,
                      LocalDate birthDate, String position, int salary, long phoneNumber) {
        super(lastName, firstName, middleName, birthDate, position, salary, phoneNumber);
    }

    public static void increaseSalary(Employee[] employees, int amount) {
        Arrays.stream(employees).filter(e -> !(e instanceof SuperVisor)).forEach(e -> e.increaseSalary(amount));
    }
}
