package ru.smolny.homework_03.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Value;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Value
public class IssueResponse {
    private static final DateTimeFormatter RU_FORMATTER = DateTimeFormatter.ofPattern(
            "d MMMM yyyy 'г.' HH:mm:ss", new Locale("ru"));

    long id;
    long bookId;
    String bookTitle;
    long readerId;
    String readerName;
    LocalDateTime issueDate;
    LocalDateTime returnDate;

    @JsonIgnore
    public String getFormattedIssueDate() {
        return RU_FORMATTER.format(issueDate);
    }

    @JsonIgnore
    public String getFormattedReturnDate() {
        return returnDate != null ? RU_FORMATTER.format(returnDate) : null;
    }
}
