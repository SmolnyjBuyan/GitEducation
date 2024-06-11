package models;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends User{
    private static int teacherId;
    private static List<Teacher> teacherList = new ArrayList<>();

    public Teacher(String lastName, String firstName, String surname) {
        this.id = ++teacherId;
        this.lastname = lastName;
        this.firstname = firstName;
        this.surname = surname;
        teacherList.add(this);
    }

    public static int getTeacherId() {
        return teacherId;
    }

    public static List<Teacher> getTeacherList() {
        return teacherList;
    }
}
