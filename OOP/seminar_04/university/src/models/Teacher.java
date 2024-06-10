package models;

public class Teacher extends User{
    public Teacher(String lastName, String firstName, String surname, int id) {
        this.id = id;
        this.lastname = lastName;
        this.firstname = firstName;
        this.surname = surname;
    }
}
