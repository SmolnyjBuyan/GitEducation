package ru.smolny.homework_03.exception;

public class ReaderNotFoundException extends ResourceNotFoundException{
    public ReaderNotFoundException(long id) {
        super("Не найден читатель с идентификатором " + id);
    }
}
