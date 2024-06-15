package service.impl;

import model.db.DataBase;
import model.impl.Teacher;
import service.UserService;

import java.util.List;

public class TeacherService implements UserService<Teacher> {

    @Override
    public Teacher create(String name, String lastName) {
        int id = DataBase.teachersDB.size() + 1;

        Teacher teacher = new Teacher(id, name, lastName);
        DataBase.teachersDB.add(teacher);
        return teacher;
    }

    @Override
    public Teacher getById(int id) throws Exception {
        Teacher teacher = DataBase.teachersDB.stream()
                .filter(s -> s.getId()==id)
                .findFirst()
                .orElse(null);

        if (teacher == null) {
            throw new Exception("Teacher not found");
        }
        return teacher;
    }

    @Override
    public List<Teacher> getAll() {
        return DataBase.teachersDB;
    }

    public void addGroupId(int group, Teacher teacher) {
        teacher.getGroups().add(group);
    }
}
