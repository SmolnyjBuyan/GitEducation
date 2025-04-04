package ru.smolny.homework_03.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Entity
@Table(name = "issues")
@Getter @Setter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Issue {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(
            "d MMMM yyyy 'г.' HH:mm:ss",
            new Locale("ru"));

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reader_id", nullable = false)
    private Reader reader;

    @Setter(AccessLevel.NONE)
    @Column(name = "issue_date", nullable = false, updatable = false)
    private LocalDateTime issueDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;


    public Issue(Book book, Reader reader) {
        this.book = book;
        this.reader = reader;
        issueDate = LocalDateTime.now();
    }

    public boolean isNotReturned() {
        return returnDate == null;
    }

    public void returnBook() {
        if (isNotReturned()) returnDate = LocalDateTime.now();
    }

    public String getIssuedDateOnRu() {
        return issueDate.format(FORMATTER);
    }

    public String getReturnedDateOnRu() {
        if (isNotReturned()) return null;
        return returnDate.format(FORMATTER);
    }
}
