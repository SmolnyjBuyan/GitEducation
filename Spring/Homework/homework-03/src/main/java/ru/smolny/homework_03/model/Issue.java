package ru.smolny.homework_03.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Issue {
    private static long sequence;
    private final long id;
    private final long bookId;
    private final long readerId;
    private final LocalDateTime timestamp;

    public Issue(long bookId, long readerId) {
        id = ++sequence;
        this.bookId = bookId;
        this.readerId = readerId;
        timestamp = LocalDateTime.now();
    }
}
