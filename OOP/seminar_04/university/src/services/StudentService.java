package services;

import models.Student;
import view.StudentView;
import view.UserView;

import java.util.List;

public class StudentService {
    private UserView<Student> studentView = new StudentView();

    public void sendOnConsole(List<Student> students) {
        studentView.sendOnConsole(students);
    }

    public Student createStudent(String lastname, String firstname, String surname, int id) {
        return new Student(lastname, firstname, surname, id);
    }
}
