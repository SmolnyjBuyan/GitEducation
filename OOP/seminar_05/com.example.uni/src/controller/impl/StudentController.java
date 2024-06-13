package controller.impl;

import controller.UserController;
import model.impl.Student;
import service.impl.StudentService;

import java.util.List;

public class StudentController implements UserController<Student> {
    private StudentService studentService = new StudentService();

    @Override
    public Student create(String name, String lastName) {
        return studentService.create(name, lastName);
    }

    @Override
    public Student getById(int id) {
        Student student = null;

        try {
            student = studentService.getById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return student;
    }

    @Override
    public List<Student> getAll() {
        return studentService.getAll();
    }
}
