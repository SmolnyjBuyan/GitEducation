package ru.smolny.homework_03.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.smolny.homework_03.model.Book;
import ru.smolny.homework_03.model.Issue;
import ru.smolny.homework_03.model.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class IssueRepository {
    @Value("${application.issue.max-allowed-books:1}")
    private int maxAllowedBooks;

    private final List<Issue> issues;

    public IssueRepository() {
        issues = new ArrayList<>();
    }

    public Optional<Issue> getById(long id) {
        return issues.stream().filter(issue -> issue.getId() == id).findFirst();
    }

    public List<Issue> getAll() {
        return issues;
    }

    public void save(Issue issue) {
        issues.add(issue);
    }

    public boolean isMaxBooksOnHand(Reader reader) {
        return issues.stream()
                .filter(issue -> (issue.getReader().equals(reader)) && !issue.isReturned())
                .count() >= maxAllowedBooks;
    }

    public boolean isBookIssued(Book book) {
        return issues.stream().anyMatch((issue -> (issue.getBook().equals(book)) && !issue.isReturned()));
    }

    public List<Issue> getByReader(Reader reader) {
        return issues.stream()
                .filter(issue -> issue.getReader().equals(reader) && !issue.isReturned()).toList();
    }
}
