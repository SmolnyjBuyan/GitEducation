package ru.smolny.model;

import lombok.Data;

import java.util.UUID;

@Data
public class AuthorResponse {
    private UUID id;
    private String firstName;
    private String lastName;
}
