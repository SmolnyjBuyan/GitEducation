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
        Teacher t1 = new Teacher(1, "Надежда", "Довбыш");
        Teacher t2 = new Teacher(2, "Тамара", "Дуркина");

        teachersDB.addAll(List.of(t1, t2));

        Student s1 = new Student(1,  "Андрей", "Котов");
        Student s2 = new Student(2,  "Сергей", "Кожевин");
        Student s3 = new Student(3, "Дмитрий", "Столяренко");
        Student s4 = new Student(4, "Михаил", "Кишинев");
        Student s5 = new Student(5, "Владимир", "Путин");
        Student s6 = new Student(6, "Владимир", "Зеленский");
        Student s7 = new Student(7, "Сергей", "Лавров");
        Student s8 = new Student(8, "Николай", "Валуев");

        studentsDB.addAll(List.of(s1,s2,s3,s4,s5,s6,s7,s8));

        studentGroupsDB.add(new StudentGroupService().createStudentGroup(1, t1, List.of(s1,s2,s3)));

    }
}
