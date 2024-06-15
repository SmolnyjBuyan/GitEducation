package controller.impl;

import controller.UserController;
import model.impl.Teacher;
import service.impl.TeacherService;

import java.util.List;

public class TeacherController implements UserController<Teacher> {
    private TeacherService teacherService = new TeacherService();

    @Override
    public Teacher create(String name, String lastName) {
        return teacherService.create(name, lastName);
    }

    @Override
    public Teacher getById(int id) {
        Teacher teacher = null;

        try {
            teacher = teacherService.getById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return teacher;
    }

    @Override
    public List<Teacher> getAll() {
        return teacherService.getAll();
    }
}
