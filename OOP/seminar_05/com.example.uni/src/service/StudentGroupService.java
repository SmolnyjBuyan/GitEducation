package service;

import model.StudentGroup;
import model.db.DataBase;
import model.impl.Student;
import model.impl.Teacher;
import service.impl.TeacherService;

import java.util.List;

public class StudentGroupService {
    TeacherService teacherService = new TeacherService();
    public StudentGroup createStudentGroup(int number,Teacher teacher, List<Student> studentList) {
        StudentGroup studentGroup = DataBase.studentGroupsDB.stream()
                .filter(n -> n.getNumber()==number)
                .findFirst()
                .orElse(null);

        if (studentGroup == null) {
            teacherService.addGroupId(number, teacher);
            for (Student student : studentList) {
                student.setGroupNumber(number);
            }
            return new StudentGroup(number, teacher, studentList);
        }

        DataBase.studentGroupsDB.add(studentGroup);
        return studentGroup;
    }
}
