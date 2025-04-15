package ru.smolny.homework_03.exception;

public class UserNotFoundException extends ResourceNotFoundException{
    public UserNotFoundException(long id) {
        super("Не найден читатель с идентификатором " + id);
    }
}
