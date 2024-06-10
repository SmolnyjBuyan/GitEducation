package services;

import models.Student;

public class StudentService {
    public Student createStudent(String lastname, String firstname, String surname, int id) {
        return new Student(lastname, firstname, surname, id);
    }
}
