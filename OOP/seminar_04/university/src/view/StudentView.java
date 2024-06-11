package view;

import models.Student;

import java.util.List;

public class StudentView implements UserView<Student> {
    @Override
    public void sendOnConsole(List<Student> students) {
        System.out.println(students);
    }
}
