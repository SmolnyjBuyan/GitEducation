package models;

public class Student implements Comparable<Student>{
    private int id;
    private String firstname;
    private String lastname;
    private String surname;

    public Student(String lastname, String firstname, String surname, int id) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.surname = surname;
        this.id = id;
    }

    @Override
    public String toString() {
        return id + ". " + lastname + " " + firstname + " " + surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public int compareTo(Student o) {
        return this.id-o.id;
    }
}
