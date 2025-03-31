package ru.smolny.homework_03.model;

import lombok.Data;

@Data
public class Reader {
    private static long sequence;
    private final long id;
    private final String name;
    private int booksOnHandCount;

    public Reader(String name) {
        id = ++sequence;
        this.name = name;
    }
}
