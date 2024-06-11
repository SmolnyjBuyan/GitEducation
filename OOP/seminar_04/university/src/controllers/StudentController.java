package controllers;

import models.Student;
import models.User;
import services.StudentService;

import java.util.List;

public class StudentController implements UserController{
    public StudentService studentService = new StudentService();

    public void sendOnConsole(List<Student> students) {
        studentService.sendOnConsole(students);
    }

    @Override
    public <T extends User> User create(T user) {
        return user;
    }
}
