package ru.smolny.homework_03.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smolny.homework_03.api.IssueRequest;
import ru.smolny.homework_03.exception.ResourceNotFoundException;
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
        if (bookRepository.getById(request.getBookId()).isEmpty()) {
            throw new ResourceNotFoundException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
        }
        if (readerRepository.getReaderById(request.getReaderId()) == null) {
            throw new ResourceNotFoundException("Не найден читатель с идентификатором \"" + request.getBookId() + "\"");
        }

        Issue issue = new Issue(request.getBookId(), request.getReaderId());
        issueRepository.save(issue);
        return issue;
    }
}
