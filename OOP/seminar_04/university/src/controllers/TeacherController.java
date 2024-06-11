package controllers;

import models.Teacher;
import services.TeacherService;

import java.util.List;

public class TeacherController implements UserController<Teacher>{
    private TeacherService teacherService = new TeacherService();

    @Override
    public Teacher create(String lastName, String firstName, String fatherName) {
        return teacherService.createTeacher(lastName, firstName, fatherName);
    }

    public void editTeacher(Teacher teacher, String lastname, String firstname, String fatherName) {
        teacherService.editTeacher(teacher, lastname, firstname, fatherName);
    }

    public void sendOnConsole(List<Teacher> teachers) {
        teacherService.sendOnConsole(teachers);
    }
}
