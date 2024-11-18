import java.time.LocalDate;
import java.util.Arrays;

public class HomeworkMain {

    public static void main(String[] args) {
        Employee andrey = new Employee("Котов", "Андрей", "Андреевич",
                LocalDate.of(1993, 10, 30), "89115554466", Customer.Gender.MALE);
        Employee dmitriy = new Employee("Чупров", "Дмитрий", "Александрович",
                LocalDate.of(1992, 1, 6), "89114445566", Customer.Gender.MALE);
        Employee anna = new Employee("Потемкина", "Анна", "Михайловна",
                LocalDate.of(2000, 12, 3), "89293338948", Customer.Gender.FEMALE);
        Employee viktor = new Employee("Гагарин", "Виктор", "Викторович",
                LocalDate.of(1992, 3,29), "89298887733", Customer.Gender.MALE);

        Employee[] employees = {andrey, dmitriy, anna, viktor};

        congratulate(employees);
    }

    public static void congratulate(Employee[] employees) {
        Holiday today = Holiday.getTodayHoliday();

        switch (today) {
            case NEW_YEAR:
                Arrays.stream(employees).forEach(e -> System.out.println(e + ", " + today.getCongratulation()));
                break;
            case WOMAN_DAY:
                Arrays.stream(employees).filter(e -> e.getSex().equals(Customer.Gender.FEMALE)).
                        forEach(e -> System.out.println(e + ", " + today.getCongratulation()));
                break;
            case MAN_DAY:
                Arrays.stream(employees).filter(e-> e.getSex().equals(Customer.Gender.MALE)).
                        forEach(e -> System.out.println(e + ", " + today.getCongratulation()));
                break;
        }
    }


}
