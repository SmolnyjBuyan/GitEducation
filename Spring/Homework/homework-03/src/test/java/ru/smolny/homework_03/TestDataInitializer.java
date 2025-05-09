package ru.smolny.homework_03;

import lombok.Getter;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.smolny.homework_03.model.*;
import ru.smolny.homework_03.repository.BookRepository;
import ru.smolny.homework_03.repository.IssueRepository;
import ru.smolny.homework_03.repository.RoleRepository;
import ru.smolny.homework_03.repository.UserRepository;

import java.util.List;
import java.util.Set;

@Component
@Profile("test")
public class TestDataInitializer {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private Role reader = Role.ofName(RoleType.READER);
    private Role admin = Role.ofName(RoleType.ADMIN);

    @Getter
    private User nice, wise, dice;
    @Getter
    private Book red, sky, cyan;
    @Getter
    private Issue redIssue, skyIssue, cyanIssue;
    @Getter
    private List<User> users;
    @Getter
    private List<Book> books;
    @Getter
    private List<Issue> issues;

    public void initData() {
        reader = roleRepository.save(Role.ofName(RoleType.READER));
        admin = roleRepository.save(Role.ofName(RoleType.ADMIN));

        initBooks();
        initUsers();
        initIssues();
    }

    private void initBooks() {
        red = bookRepository.save(new Book("Red"));
        sky = bookRepository.save(new Book("Sky"));
        cyan = bookRepository.save(new Book("Cyan"));
        books = List.of(red, sky, cyan);
    }

    public void initUsers() {
        nice = userRepository.save(User.builder()
                .username("nice")
                .password(passwordEncoder.encode("1234"))
                .firstname("Найс")
                .roles(Set.of(reader))
                .build());

        wise = userRepository.save(User.builder()
                .username("wise")
                .password(passwordEncoder.encode("1234"))
                .firstname("Вайс")
                .roles(Set.of(reader))
                .build());

        dice = userRepository.save(User.builder()
                .username("dice")
                .password(passwordEncoder.encode("1234"))
                .firstname("Дайс")
                .roles(Set.of(reader))
                .build());

        users = List.of(nice, wise, dice);
    }

    private void initIssues() {
        redIssue = issueRepository.save(new Issue(red, wise));
        skyIssue = issueRepository.save(new Issue(sky, wise));
        cyanIssue = issueRepository.save(new Issue(cyan, dice));
        issues = List.of(redIssue, skyIssue, cyanIssue);
    }

    public void cleanAll() {
        issueRepository.deleteAll();
        userRepository.deleteAll();
        bookRepository.deleteAll();
        roleRepository.deleteAll();
    }

    @Transactional
    public List<Issue> getWiseIssues() {
        wise = userRepository.findById(wise.getId()).orElseThrow(() -> new AssertionError(""));
        return wise.getIssues();
    }
}
