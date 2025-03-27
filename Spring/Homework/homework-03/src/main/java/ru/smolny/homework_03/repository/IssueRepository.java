package ru.smolny.homework_03.repository;

import org.springframework.stereotype.Repository;
import ru.smolny.homework_03.model.Issue;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IssueRepository {
    private final List<Issue> issues;

    public IssueRepository() {
        issues = new ArrayList<>();
    }

    public void save(Issue issue) {
        issues.add(issue);
    }
}
