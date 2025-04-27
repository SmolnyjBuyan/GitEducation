package ru.smolny.model;

import lombok.Data;

import java.util.UUID;

@Data
public class BookResponse {
    private UUID id;
    private String title;
    private AuthorResponse author;
}
