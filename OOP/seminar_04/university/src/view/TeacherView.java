package view;

import models.Teacher;

import java.util.List;

public class TeacherView implements UserView<Teacher>{
    @Override
    public void sendOnConsole(List<Teacher> teachers) {
        System.out.println(teachers);
    }
}
