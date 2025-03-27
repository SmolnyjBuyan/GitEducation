package ru.smolny.homework_03.model;

import lombok.Data;

@Data
public class Book {
    private static long sequence;
    private final long id;
    private final String title;

    public Book(String title) {
        id = ++sequence;
        this.title = title;
    }
}
