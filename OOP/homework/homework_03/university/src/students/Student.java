package students;

public class Student {
    private String firstname;
    private String lastname;
    private String surname;

    public Student(String lastname, String firstname, String surname) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return lastname + " " + firstname + " " + surname;
    }
}
