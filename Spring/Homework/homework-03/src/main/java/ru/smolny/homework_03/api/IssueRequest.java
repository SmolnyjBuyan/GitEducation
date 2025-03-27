package ru.smolny.homework_03.api;

import lombok.Data;

@Data
public class IssueRequest {
    private final long readerId;
    private final long bookId;
}
