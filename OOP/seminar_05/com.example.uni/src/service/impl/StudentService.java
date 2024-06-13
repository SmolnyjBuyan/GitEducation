package service.impl;

import model.db.DataBase;
import model.impl.Student;
import service.UserService;

import java.util.List;

public class StudentService implements UserService<Student> {
    @Override
    public Student create(String name, String lastName) {
        int id = DataBase.studentsDB.size() + 1;

        Student student = new Student(id, name, lastName);
        DataBase.studentsDB.add(student);
        return student;
    }

    @Override
    public Student getById(int id) throws Exception {
        Student student = DataBase.studentsDB.stream()
                .filter(s -> s.getId()==id)
                .findFirst()
                .orElse(null);

        if (student == null) {
            throw new Exception("Student not found");
        }
        return student;
    }

    @Override
    public List<Student> getAll() {
        return DataBase.studentsDB;
    }

}
