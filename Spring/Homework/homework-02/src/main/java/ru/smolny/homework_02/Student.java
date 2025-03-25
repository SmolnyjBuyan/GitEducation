package ru.smolny.homework_02;

import lombok.Data;

@Data
public class Student {
    private static long idCounter;
    private final long id;
    private String name;
    private String groupName;

    public Student(String name, String groupName) {
        id = ++idCounter;
        this.name = name;
        this.groupName = groupName;
    }
}
