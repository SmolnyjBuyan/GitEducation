package ru.smolny.homework_03.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.smolny.homework_03.dto.IssueRequest;
import ru.smolny.homework_03.dto.IssueResponse;
import ru.smolny.homework_03.exception.*;
import ru.smolny.homework_03.mapper.IssueMapper;
import ru.smolny.homework_03.model.Book;
import ru.smolny.homework_03.model.Issue;
import ru.smolny.homework_03.model.User;
import ru.smolny.homework_03.repository.BookRepository;
import ru.smolny.homework_03.repository.IssueRepository;
import ru.smolny.homework_03.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueService {
    @Value("${application.issue.max-allowed-books:1}")
    private int maxAllowedBooks;

    private final BookService bookService;
    private final ReaderService readerService;

    private final IssueRepository issueRepository;

    public Issue issue(IssueRequest request) {
        Book book = bookService.getById(request.getBookId());
        if (!book.isAvailable()) throw new BookAlreadyOnHandException();

        User reader = readerService.getById(request.getReaderId());
        if (isMaxBooksOnHand(reader)) throw new BookLimitException();

        Issue issue = new Issue(book, reader);
        return issueRepository.save(issue);
    }

    public Issue getById(long id) {
        return issueRepository.findById(id).orElseThrow(() -> new IssueNotFoundException(id));
    }

    public List<Issue> getAll() {
        return issueRepository.findAll();
    }

    @Transactional
    public Issue returnBook(long id) {
        Issue issue = issueRepository.findById(id).orElseThrow(() -> new IssueNotFoundException(id));
        issue.returnBook();
        return issue;
    }

    private boolean isMaxBooksOnHand(User reader) {
        return reader.getNotReturnedIssues().size() >= maxAllowedBooks;
    }
}
