package services;

import models.Student;
import models.Teacher;
import view.TeacherView;
import view.UserView;

import java.util.List;

public class TeacherService {
    private UserView<Teacher> teacherView = new TeacherView();

    public void sendOnConsole(List<Teacher> teachers) {
        teacherView.sendOnConsole(teachers);
    }

    public Teacher createTeacher(String lastname, String firstname, String surname) {
        return new Teacher(lastname, firstname, surname);
    }

    public void editTeacher(Teacher teacher, String lastname, String firstname, String fatherName) {
        teacher.setLastname(lastname);
        teacher.setFirstname(firstname);
        teacher.setSurname(fatherName);
    }
}
