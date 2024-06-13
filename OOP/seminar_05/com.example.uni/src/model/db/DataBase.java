package model.db;

import model.impl.Student;
import model.impl.Teacher;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    public static final List<Student> studentsDB = new ArrayList<>();

    public static final List<Teacher> teachersDB = new ArrayList<>();

    public static void fillDB(){
        Teacher teacher = new Teacher(1, "Надежда", "Довбыш");
        teacher.addGroupId(1);
        teachersDB.add(teacher);

        Student s1 = new Student(1,  "Котов", "Андрей", 1);
        Student s2 = new Student(2,  "Кожевин", "Сергей", 2);
        studentsDB.add(s1);
        studentsDB.add(s2);

    }
}
