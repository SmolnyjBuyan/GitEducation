package ru.smolny.api;

import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smolny.ExecutionTimeLog;
import ru.smolny.model.Issue;
import ru.smolny.service.BookProvider;
import ru.smolny.service.ReaderProvider;

import java.time.ZoneId;
import java.util.*;

@RestController
@RequestMapping("/api/issue")
public class IssueController {
    private final Faker faker;
    private final List<Issue> issues;
    private final BookProvider bookProvider;
    private final ReaderProvider readerProvider;

    public IssueController(BookProvider bookProvider, ReaderProvider readerProvider) {
        this.faker = new Faker();
        this.bookProvider = bookProvider;
        this.readerProvider = readerProvider;
        this.issues = new ArrayList<>();

        refreshData();
    }

    private Date startOfYear() {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, 2024);
        instance.set(Calendar.MONTH, Calendar.JANUARY);
        instance.set(Calendar.DAY_OF_MONTH, 1);
        return instance.getTime();
    }

    private Date endOfYear() {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, 2024);
        instance.set(Calendar.MONTH, Calendar.DECEMBER);
        instance.set(Calendar.DAY_OF_MONTH, 31);
        return instance.getTime();
    }

    @ExecutionTimeLog
    @GetMapping
    public List<Issue> getAll() {
        return issues;
    }

    @ExecutionTimeLog
    @GetMapping("/refresh")
    public List<Issue> refresh() {
        refreshData();
        return getAll();
    }

    private void refreshData() {
        issues.clear();
        for (int i = 0; i < 15; i++) {
            Issue issue = new Issue();
            issue.setId(UUID.randomUUID());
            Date between = faker.date().between(startOfYear(), endOfYear());
            issue.setIssuedAt(between.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            issue.setBook(bookProvider.getRandomBook());
            issue.setReader(readerProvider.getRandomReader());

            issues.add(issue);
        }
    }
}
