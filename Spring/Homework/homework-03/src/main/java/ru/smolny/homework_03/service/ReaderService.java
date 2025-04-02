package ru.smolny.homework_03.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smolny.homework_03.exception.ReaderNotFoundException;
import ru.smolny.homework_03.model.Issue;
import ru.smolny.homework_03.model.Reader;
import ru.smolny.homework_03.repository.IssueRepository;
import ru.smolny.homework_03.repository.ReaderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService {
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    public Reader getById(long id) {
        return readerRepository.getById(id).orElseThrow(() -> new ReaderNotFoundException(id));
    }

    public List<Reader> getAll() {
        return readerRepository.getAll();
    }

    public void deleteById(long id) {
        if (!readerRepository.deleteById(id)) throw new ReaderNotFoundException(id);
    }

    public Reader create(String name) {
        return readerRepository.create(name);
    }

    public List<Issue> getIssuesByReaderId(long id) {
        Reader reader = getById(id);
        return issueRepository.getByReader(reader);
    }

}
