package ru.smolny.homework_03.exception;

public class ResourceAlreadyExistsException extends RuntimeException{
    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}
