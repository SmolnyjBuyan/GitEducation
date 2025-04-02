package ru.smolny.homework_03.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

@Data
public class Issue {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(
            "d MMMM yyyy 'г.' HH:mm:ss",
            new Locale("ru"));;

    private static long sequence;
    private final long id;
    private final Book book;
    private final Reader reader;
    private final LocalDateTime issuedAt;
    private LocalDateTime returnedAt;


    public Issue(Book book, Reader reader) {
        id = ++sequence;
        this.book = book;
        this.reader = reader;
        issuedAt = LocalDateTime.now();
    }

    public void returnBook() {
        if (returnedAt == null) returnedAt = LocalDateTime.now();
    }

    public boolean isReturned() {
        return returnedAt != null;
    }

    public String getIssuedDateOnRu() {
        return issuedAt.format(FORMATTER);
    }

    public String getReturnedDateOnRu() {
        if (returnedAt == null) return null;
        return returnedAt.format(FORMATTER);
    }
}
