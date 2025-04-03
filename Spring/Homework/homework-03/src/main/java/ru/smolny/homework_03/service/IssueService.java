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
import ru.smolny.homework_03.repository.OldBookRepository;
import ru.smolny.homework_03.repository.IssueRepository;
import ru.smolny.homework_03.repository.ReaderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueService {
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

//    @PostConstruct
//    private void generateData() {
//        issue(new IssueRequest(1, 2));
//        issue(new IssueRequest(2, 1));
//        issue(new IssueRequest(1, 3));
//    }

    public Issue issue(IssueRequest request) {
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new BookNotFoundException(request.getBookId()));
        if (issueRepository.isBookIssued(book)) throw new BookAlreadyOnHandException();

        Reader reader = readerRepository.getById(request.getReaderId())
                .orElseThrow(() -> new ReaderNotFoundException(request.getReaderId()));
        if (issueRepository.isMaxBooksOnHand(reader)) throw new BookLimitException();

        Issue issue = new Issue(book, reader);
        issueRepository.save(issue);
        return issue;
    }

    public Issue getById(long id) {
        return issueRepository.getById(id)
                .orElseThrow(() -> new IssueNotFoundException(id));
    }

    public List<Issue> getAll() {
        return issueRepository.getAll();
    }

    public Issue returnBook(long id) {
        Issue issue = getById(id);
        issue.returnBook();
        return issue;
    }
}
