package ru.smolny.homework_03.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.smolny.homework_03.dto.IssueResponse;
import ru.smolny.homework_03.dto.UserRequest;
import ru.smolny.homework_03.exception.ReaderNotFoundException;
import ru.smolny.homework_03.exception.RoleNotFoundException;
import ru.smolny.homework_03.mapper.IssueMapper;
import ru.smolny.homework_03.model.Issue;
import ru.smolny.homework_03.model.Role;
import ru.smolny.homework_03.model.RoleType;
import ru.smolny.homework_03.model.User;
import ru.smolny.homework_03.repository.RoleRepository;
import ru.smolny.homework_03.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final IssueMapper issueMapper;
    private final PasswordEncoder passwordEncoder;

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
        return userRepository.findByRoleName(RoleType.READER);
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public User create(UserRequest request) {
        User user = new User(
                request.getName(),
                passwordEncoder.encode(request.getPassword()),
                request.getFirstname());
        Role role = roleRepository.findByName(RoleType.READER)
                .orElseThrow(() -> new RoleNotFoundException(RoleType.READER));
        user.addRole(role);
        return userRepository.save(user);
    }

    public List<IssueResponse> getIssuesByReaderId(long id) {
        User reader = userRepository.findById(id).orElseThrow(() -> new ReaderNotFoundException(id));
        List<Issue> notReturnedIssues = reader.getNotReturnedIssues();
        return issueMapper.toIssueResponseList(notReturnedIssues);
    }
}
