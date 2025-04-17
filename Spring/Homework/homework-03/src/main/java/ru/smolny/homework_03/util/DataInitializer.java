package ru.smolny.homework_03.util;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.smolny.homework_03.dto.ReaderRequest;
import ru.smolny.homework_03.model.*;
import ru.smolny.homework_03.repository.BookRepository;
import ru.smolny.homework_03.repository.IssueRepository;
import ru.smolny.homework_03.repository.RoleRepository;
import ru.smolny.homework_03.repository.UserRepository;
import ru.smolny.homework_03.service.ReaderService;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {
    private final BookRepository bookRepository;
    private final ReaderService readerService;
    private final IssueRepository issueRepository;
    private final RoleRepository roleRepository;

    @Bean
    CommandLineRunner initTestData() {
        return args -> {
            Book book1 = bookRepository.save(new Book("Война и Мир"));
            Book book2 = bookRepository.save(new Book("Мертвые души"));
            Book book3 = bookRepository.save(new Book("Философия JAVA"));

            Role reader = new Role();
            reader.setName(RoleType.READER);

            Role adminRole = new Role();
            adminRole.setName(RoleType.ADMIN);
            roleRepository.save(reader);
            roleRepository.save(adminRole);

            User reader1 = readerService.create(new ReaderRequest("andrey", "1234", "Андрей"));
            User reader2 = readerService.create(new ReaderRequest("darya", "1234", "Дарья"));
            User reader3 = readerService.create(new ReaderRequest("nikolay", "1234", "Николай"));

            issueRepository.save(new Issue(book2, reader1));
            issueRepository.save(new Issue(book1, reader2));
            issueRepository.save(new Issue(book3, reader1));
        };
    }
}
