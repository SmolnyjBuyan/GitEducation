package ru.smolny.homework_03.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smolny.homework_03.dto.IssueResponse;
import ru.smolny.homework_03.dto.ReaderResponse;
import ru.smolny.homework_03.exception.ReaderNotFoundException;
import ru.smolny.homework_03.mapper.IssueMapper;
import ru.smolny.homework_03.mapper.ReaderMapper;
import ru.smolny.homework_03.model.Issue;
import ru.smolny.homework_03.model.Reader;
import ru.smolny.homework_03.repository.ReaderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService {
    private final ReaderRepository readerRepository;
    private final ReaderMapper readerMapper;
    private final IssueMapper issueMapper;

    public ReaderResponse getById(long id) {
        Reader reader = readerRepository.findById(id).orElseThrow(() -> new ReaderNotFoundException(id));
        return readerMapper.toReaderResponse(reader);
    }

    public List<ReaderResponse> getAll() {
        List<Reader> readers = readerRepository.findAll();
        return readerMapper.toReaderResponseList(readers);
    }

    public void deleteById(long id) {
        readerRepository.deleteById(id);
    }

    public ReaderResponse create(String name) {
        Reader reader =  readerRepository.save(new Reader(name));
        return readerMapper.toReaderResponse(reader);
    }

    public List<IssueResponse> getIssuesByReaderId(long id) {
        Reader reader = readerRepository.findById(id).orElseThrow(() -> new ReaderNotFoundException(id));
        List<Issue> notReturnedIssues = reader.getNotReturnedIssues();
        return issueMapper.toIssueResponseList(notReturnedIssues);
    }
}
