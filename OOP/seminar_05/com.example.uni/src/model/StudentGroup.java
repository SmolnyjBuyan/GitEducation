package model;

import model.impl.Student;
import model.impl.Teacher;

import java.util.List;

public class StudentGroup {
    private int number;
    private Teacher teacher;
    private List<Student> studentList;

    public StudentGroup(int number, Teacher teacher, List<Student> studentList) {
        this.number = number;
        this.teacher = teacher;
        this.studentList = studentList;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StudentGroup number = ").append(number);
        sb.append("\n\tteacher = ").append(teacher).append("\n");

        for (Student s : studentList) {
            sb.append("\t\t").append(s.toString()).append("\n");
        }

        return sb.toString();
    }
}
