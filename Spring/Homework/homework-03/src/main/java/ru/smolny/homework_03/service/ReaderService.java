package ru.smolny.homework_03.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smolny.homework_03.dto.IssueResponse;
import ru.smolny.homework_03.exception.ReaderNotFoundException;
import ru.smolny.homework_03.mapper.IssueMapper;
import ru.smolny.homework_03.model.Issue;
import ru.smolny.homework_03.model.RoleType;
import ru.smolny.homework_03.model.User;
import ru.smolny.homework_03.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService {
    private final UserRepository userRepository;
    private final IssueMapper issueMapper;

    public User getById(long id) {
        User reader = userRepository.findById(id).orElseThrow(() -> new ReaderNotFoundException(id));
        if (!isReader(reader)) throw new ReaderNotFoundException(id);
        return reader;
    }

    public boolean isReader(User user) {
        return user.getRoles().stream()
                .anyMatch(role -> role.getName() == RoleType.READER);
    }

    public List<User> getAll() {
        return userRepository.findByRoleName(String.valueOf(RoleType.READER));
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    public User create(String name, String password) {
        return userRepository.save(new User(name, password));
    }

    public List<IssueResponse> getIssuesByReaderId(long id) {
        User reader = userRepository.findById(id).orElseThrow(() -> new ReaderNotFoundException(id));
        List<Issue> notReturnedIssues = reader.getNotReturnedIssues();
        return issueMapper.toIssueResponseList(notReturnedIssues);
    }
}
