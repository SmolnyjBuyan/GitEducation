package model.impl;

import model.User;

public class Student extends User {
    private int groupId;

    public Student(int id, String name, String lastName, int groupId) {
        super(id, name, lastName);
        this.groupId = groupId;
    }
}
