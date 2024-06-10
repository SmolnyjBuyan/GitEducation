package models;

public class Student extends User{

    public Student(String lastName, String firstName, String surname, int id) {
        this.id = id;
        this.lastname = lastName;
        this.firstname = firstName;
        this.surname = surname;
    }
}
