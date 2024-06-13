package model.impl;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends User {
    private final List<Integer> groups = new ArrayList<>();

    public Teacher(int id, String name, String lastName) {
        super(id, name, lastName);
    }

    public List<Integer> getGroups() {
        return groups;
    }

    public String toString() {
        return String.format("Teacher[id=%s, name=%s, lastName=%s]", id, name, lastName);
    }
}
