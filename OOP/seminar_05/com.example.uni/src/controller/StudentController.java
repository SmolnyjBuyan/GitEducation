package controller;

import model.impl.Student;
import service.StudentService;

import java.util.List;

public class StudentController {
    private StudentService studentService = new StudentService();

    public Student createStudent(String name, String lastName, int groupId) {
        return studentService.createStudent(name, lastName, groupId);
    }

    public Student getStudentById(int id) {
        Student student = null;

        try {
            student = studentService.getStudentById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return student;
    }

    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

}
