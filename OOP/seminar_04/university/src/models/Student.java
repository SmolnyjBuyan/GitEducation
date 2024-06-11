package models;

public class Student extends User{
    private static int studentId;

    public Student(String lastName, String firstName, String surname) {
        this.id = ++studentId;
        this.lastname = lastName;
        this.firstname = firstName;
        this.surname = surname;
    }
}
