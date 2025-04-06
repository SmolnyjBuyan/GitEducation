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
import ru.smolny.homework_03.model.Reader;
import ru.smolny.homework_03.repository.BookRepository;
import ru.smolny.homework_03.repository.IssueRepository;
import ru.smolny.homework_03.repository.ReaderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueService {
    @Value("${application.issue.max-allowed-books:1}")
    private int maxAllowedBooks;

    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;
    private final IssueMapper issueMapper;

    public IssueResponse issue(IssueRequest request) {
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new BookNotFoundException(request.getBookId()));
        if (!book.isAvailable()) throw new BookAlreadyOnHandException();

        Reader reader = readerRepository.findById(request.getReaderId())
                .orElseThrow(() -> new ReaderNotFoundException(request.getReaderId()));
        if (isMaxBooksOnHand(reader)) throw new BookLimitException();

        Issue issue = new Issue(book, reader);
        issueRepository.save(issue);
        return issueMapper.toIssueResponse(issue);
    }

    public IssueResponse getById(long id) {
        Issue issue = issueRepository.findById(id).orElseThrow(() -> new IssueNotFoundException(id));
        return issueMapper.toIssueResponse(issue);
    }

    public List<IssueResponse> getAll() {
        List<Issue> issues = issueRepository.findAll();
        return issueMapper.toIssueResponseList(issues);
    }

    @Transactional
    public IssueResponse returnBook(long id) {
        Issue issue = issueRepository.findById(id).orElseThrow(() -> new IssueNotFoundException(id));
        issue.returnBook();
        return issueMapper.toIssueResponse(issue);
    }

    private boolean isMaxBooksOnHand(Reader reader) {
        return reader.getNotReturnedIssues().size() >= maxAllowedBooks;
    }
}
