package ru.smolny.lection_04;

import lombok.Data;

@Data
public class User {
    private Long id;
    private final String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
