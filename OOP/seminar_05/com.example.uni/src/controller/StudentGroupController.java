package controller;

import model.StudentGroup;
import model.impl.Student;
import model.impl.Teacher;
import service.StudentGroupService;

import java.util.List;

public class StudentGroupController {
    private StudentGroupService studentGroupService = new StudentGroupService();

    public StudentGroup createStudentGroup(int number, Teacher teacher, List<Student> studentList) {
        return studentGroupService.createStudentGroup(number, teacher, studentList);
    }
}
