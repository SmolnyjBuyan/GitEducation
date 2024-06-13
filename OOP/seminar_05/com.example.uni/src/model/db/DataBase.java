package model.db;

import model.StudentGroup;
import model.impl.Student;
import model.impl.Teacher;
import service.StudentGroupService;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    public static final List<Student> studentsDB = new ArrayList<>();

    public static final List<Teacher> teachersDB = new ArrayList<>();
    public static final List<StudentGroup> studentGroupsDB = new ArrayList<>();

    public static void fillDB(){
        Teacher teacher = new Teacher(1, "Надежда", "Довбыш");
        teachersDB.add(teacher);

        Student s1 = new Student(1,  "Котов", "Андрей");
        Student s2 = new Student(2,  "Кожевин", "Сергей");
        Student s3 = new Student(3, "Столяренко", "Дмитрий");
        studentsDB.add(s1);
        studentsDB.add(s2);
        studentsDB.add(s3);

    }
}
