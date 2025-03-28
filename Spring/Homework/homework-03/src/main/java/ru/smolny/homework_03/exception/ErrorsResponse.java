package ru.smolny.homework_03.exception;

import lombok.Data;

import java.util.List;

@Data
public class ErrorsResponse {
    private final String error;
    private final List<String> message;
}
