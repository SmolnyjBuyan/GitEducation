package ru.smolny.homework_03.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.smolny.homework_03.model.Issue;

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


    public void save(Issue issue) {
        issues.add(issue);
    }

    public boolean isMaxBooksOnHand(long readerId) {
        return issues.stream()
                .filter(issue -> (issue.getReaderId() == readerId) && !issue.isReturned())
                .count() >= maxAllowedBooks;
    }

    public boolean isBookIssued(long bookId) {
        return issues.stream().anyMatch((issue -> (issue.getBookId() == bookId) && !issue.isReturned()));
    }

    public List<Issue> getByReaderId(long readerId) {
        return issues.stream()
                .filter(issue -> issue.getReaderId() == readerId && !issue.isReturned()).toList();
    }
}
