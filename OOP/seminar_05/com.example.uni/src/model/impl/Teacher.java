package model.impl;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends User {
    private final List<Integer> groups = new ArrayList<>();

    public Teacher(int id, String name, String lastName) {
        super(id, name, lastName);
    }

    //убрать в сервис
    public void addGroupId(int group) {
        groups.add(group);
    }
}
