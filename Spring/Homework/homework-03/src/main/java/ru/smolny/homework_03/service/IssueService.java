package ru.smolny.homework_03.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smolny.homework_03.api.IssueRequest;
import ru.smolny.homework_03.exception.*;
import ru.smolny.homework_03.model.Issue;
import ru.smolny.homework_03.repository.BookRepository;
import ru.smolny.homework_03.repository.IssueRepository;
import ru.smolny.homework_03.repository.ReaderRepository;

@Service
@RequiredArgsConstructor
public class IssueService {
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    public Issue issue(IssueRequest request) {
        checkBook(request.getBookId());
        checkReader(request.getReaderId());

        Issue issue = new Issue(request.getBookId(), request.getReaderId());
        issueRepository.save(issue);
        return issue;
    }

    public Issue getById(long id) {
        return issueRepository.getById(id)
                .orElseThrow(() -> new IssueNotFoundException(id));
    }

    private void checkBook(long id) {
        bookRepository.getById(id).orElseThrow(() -> new BookNotFoundException(id));
        if (issueRepository.isBookIssued(id)) throw new BookAlreadyOnHandException();
    }

    private void checkReader(long id) {
        readerRepository.getById(id).orElseThrow(() -> new ReaderNotFoundException(id));
        if (issueRepository.isMaxBooksOnHand(id)) throw new BookLimitException();
    }

    public Issue returnBook(long id) {
        Issue issue = getById(id);
        issue.returnBook();
        return issue;
    }
}
