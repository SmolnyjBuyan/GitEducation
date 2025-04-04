package ru.smolny.homework_03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.smolny.homework_03.model.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
