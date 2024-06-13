package service;

import model.db.DataBase;
import model.impl.Student;

import java.util.List;

public class StudentService {

    public Student createStudent(String name, String lastName, int groupId) {
        int id = DataBase.studentsDB.size() + 1;

        Student student = new Student(id, name, lastName, groupId);
        return student;
    }

    public Student getStudentById(int id) throws Exception {
        Student student = DataBase.studentsDB.stream()
                .filter(s -> s.getId()==id)
                .findFirst()
                .orElse(null);

        if (student == null) {
            throw new Exception("Student not found");
        }
        return student;
    }

    public List<Student> getAllStudents() {
        return DataBase.studentsDB;
    }
}
