package ru.smolny.homework_03.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smolny.homework_03.dto.IssueResponse;
import ru.smolny.homework_03.dto.ReaderResponse;
import ru.smolny.homework_03.exception.UserNotFoundException;
import ru.smolny.homework_03.mapper.IssueMapper;
import ru.smolny.homework_03.mapper.ReaderMapper;
import ru.smolny.homework_03.model.Issue;
import ru.smolny.homework_03.model.RoleType;
import ru.smolny.homework_03.model.User;
import ru.smolny.homework_03.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService {
    private final UserRepository userRepository;
    private final ReaderMapper readerMapper;
    private final IssueMapper issueMapper;

    public ReaderResponse getById(long id) {
        User reader = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return readerMapper.toReaderResponse(reader);
    }

    public boolean isReader(User user) {
        return user.getRoles().stream()
                .anyMatch(role -> role.getName() == RoleType.READER);
    }

    public List<ReaderResponse> getAll() {
        List<User> readers = userRepository.findAll();
        return readerMapper.toReaderResponseList(readers);
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    public ReaderResponse create(String name) {
        User reader =  userRepository.save(new User(name));
        return readerMapper.toReaderResponse(reader);
    }

    public List<IssueResponse> getIssuesByReaderId(long id) {
        User reader = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        List<Issue> notReturnedIssues = reader.getNotReturnedIssues();
        return issueMapper.toIssueResponseList(notReturnedIssues);
    }
}
