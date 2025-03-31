package ru.smolny.homework_03.exception;

public class BookLimitException extends RuntimeException {
    public BookLimitException(){
        super("Достигнут предел количества книг на руки");
    }
}
