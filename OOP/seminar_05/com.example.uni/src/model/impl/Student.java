package model.impl;

import model.User;

public class Student extends User {

    private int groupNumber;

    public Student(int id, String name, String lastName) {
        super(id, name, lastName);
    }

    @Override
    public String toString() {
        return String.format("Student[id=%s, name=%s, lastName=%s, groupNumber=%s]", id, name, lastName, groupNumber);
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }
}
