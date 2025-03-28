package ru.smolny.homework_03.exception;

public class BookAlreadyExistsException extends ResourceAlreadyExistsException{
    public BookAlreadyExistsException(String title) {
        super("Книга с названием '" + title + "' уже существует");
    }
}
