package ru.smolny.seminar_02;

import lombok.Data;

@Data
public class User {
    private static long idCounter = 1L;
    private final long id;
    private String name;

    public User(String name) {
        this.id = idCounter++;
        this.name = name;
    }
}
