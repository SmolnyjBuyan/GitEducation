package ru.smolny.homework_03.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smolny.homework_03.api.IssueRequest;
import ru.smolny.homework_03.exception.*;
import ru.smolny.homework_03.model.Book;
import ru.smolny.homework_03.model.Issue;
import ru.smolny.homework_03.model.Reader;
import ru.smolny.homework_03.repository.BookRepository;
import ru.smolny.homework_03.repository.IssueRepository;
import ru.smolny.homework_03.repository.ReaderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueService {
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    public Issue issue(IssueRequest request) {
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new BookNotFoundException(request.getBookId()));
        if (!book.isAvailable()) throw new BookAlreadyOnHandException();

        Reader reader = readerRepository.findById(request.getReaderId())
                .orElseThrow(() -> new ReaderNotFoundException(request.getReaderId()));
        if (reader.isMaxBooksOnHand()) throw new BookLimitException();

        Issue issue = new Issue(book, reader);
        issueRepository.save(issue);
        return issue;
    }

    public Issue getById(long id) {
        Issue issue = issueRepository.findById(id).orElseThrow(() -> new IssueNotFoundException(id));
        return issue;
    }

    public List<Issue> getAll() {
        return issueRepository.findAll();
    }

    public Issue returnBook(long id) {
        Issue issue = getById(id);
        issue.returnBook();
        Book book = issue.getBook();
        bookRepository.save(book);
        return issue;
    }
}
