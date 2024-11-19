import java.time.LocalDate;

public class Customer {
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private String phoneNumber;

    public Customer(String lastName, String firstName, String middleName, LocalDate birthDate, String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    public enum Gender {

        MALE("Мужской"), FEMALE("Женский");

        private final String russianTitle;

        Gender(String title) {
            russianTitle = title;
        }

        public String getRussianTitle() {
            return russianTitle;
        }
    }
}
