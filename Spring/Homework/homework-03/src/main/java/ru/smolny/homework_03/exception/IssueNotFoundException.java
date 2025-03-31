package ru.smolny.homework_03.exception;

public class IssueNotFoundException extends ResourceNotFoundException{
    public IssueNotFoundException(long id) {
        super("Не найдена запись с идентификатором " + id);
    }
}
