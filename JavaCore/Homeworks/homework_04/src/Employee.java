import java.time.LocalDate;

public class Employee {
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private String phoneNumber;
    private Customer.Gender sex;

    public Employee(String lastName, String firstName, String middleName,
                    LocalDate birthDate, String phoneNumber, Customer.Gender sex) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Customer.Gender getSex() {
        return sex;
    }

    public void setSex(Customer.Gender sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return lastName + ' ' + firstName + ' ' + middleName;
    }
}
