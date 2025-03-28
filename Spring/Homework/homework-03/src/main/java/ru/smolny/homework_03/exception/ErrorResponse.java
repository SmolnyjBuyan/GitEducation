package ru.smolny.homework_03.exception;

import lombok.Data;

@Data
public class ErrorResponse {
    private final String error;
    private final String message;
}
