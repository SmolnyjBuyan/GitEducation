package ru.smolny.homework_03.util;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.smolny.homework_03.model.*;
import ru.smolny.homework_03.repository.BookRepository;
import ru.smolny.homework_03.repository.IssueRepository;
import ru.smolny.homework_03.repository.RoleRepository;
import ru.smolny.homework_03.repository.UserRepository;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final IssueRepository issueRepository;
    private final RoleRepository roleRepository;

    @Bean
    CommandLineRunner initTestData() {
        return args -> {
            Book book1 = bookRepository.save(new Book("Война и Мир"));
            Book book2 = bookRepository.save(new Book("Мертвые души"));
            Book book3 = bookRepository.save(new Book("Философия JAVA"));

            roleRepository.save(new Role(RoleType.READER));
            roleRepository.save(new Role(RoleType.ADMIN));

            User reader1 = userRepository.save(new User("Андрей", "1234"));
            User reader2 = userRepository.save(new User("Дарья", "1234"));
            User reader3 = userRepository.save(new User("Николай", "1234"));

            issueRepository.save(new Issue(book2, reader1));
            issueRepository.save(new Issue(book1, reader2));
            issueRepository.save(new Issue(book3, reader1));
        };
    }
}
