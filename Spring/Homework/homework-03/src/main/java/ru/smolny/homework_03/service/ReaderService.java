package ru.smolny.homework_03.service;

import jakarta.annotation.PostConstruct;
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

    public Reader getById(long id) {
        return readerRepository.findById(id).orElseThrow(() -> new ReaderNotFoundException(id));
    }

    public List<Reader> getAll() {
        return readerRepository.findAll();
    }

    public void deleteById(long id) {
        readerRepository.deleteById(id);
    }

    public Reader create(String name) {
        return readerRepository.save(new Reader(name));
    }

    public List<Issue> getIssuesByReaderId(long id) {
        Reader reader = getById(id);
        return reader.getNotReturnedIssues();
    }
}
