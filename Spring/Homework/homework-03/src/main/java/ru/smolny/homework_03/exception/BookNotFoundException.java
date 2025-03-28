package ru.smolny.homework_03.exception;

public class BookNotFoundException extends ResourceNotFoundException{
    public BookNotFoundException(long id) {
        super("Не найдена книга с идентификатором " + id);
    }
}
