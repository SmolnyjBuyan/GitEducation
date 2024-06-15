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
            studentGroup = new StudentGroup(number, teacher, studentList);
            DataBase.studentGroupsDB.add(studentGroup);
        }

        return studentGroup;
    }

    public StudentGroup getStudentGroupByNumber(int number) throws Exception {
        StudentGroup studentGroup = DataBase.studentGroupsDB.stream()
                .filter(sg -> sg.getNumber()==number)
                .findFirst()
                .orElse(null);

        if (studentGroup == null) {
            throw new Exception("Student Group not found");
        }

        return studentGroup;
    }

    public void getAllStudentGroups() {
        for (StudentGroup studentGroup : DataBase.studentGroupsDB) {
            System.out.println(studentGroup);
        }
    }

    public boolean checkStudentGroup(int number) {
        return DataBase.studentGroupsDB.stream().anyMatch(sg -> sg.getNumber()==number);
    }
}
