package ru.smolny.homework_03.exception;

public class BookAlreadyOnHandException extends RuntimeException {
    public BookAlreadyOnHandException() {
        super("Запрашиваемая книга уже на руках");
    }
}
