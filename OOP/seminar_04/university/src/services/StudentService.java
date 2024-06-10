package services;

import models.Student;
import models.StudentGroup;
import util.UserView;

public class StudentService {
    public Student createStudent(String lastname, String firstname, String surname, int id) {
        return new Student(lastname, firstname, surname, id);
    }
}
