package controllers;

import models.Student;
import services.StudentService;

import java.util.List;

public class StudentController implements UserController<Student>{
    public StudentService studentService = new StudentService();

    public void sendOnConsole(List<Student> students) {
        studentService.sendOnConsole(students);
    }

    @Override
    public Student create(String lastName, String firstName, String fatherName) {
        return studentService.createStudent(lastName, firstName, fatherName);
    }
}
