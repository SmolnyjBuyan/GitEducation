package ru.smolny.homework_03.util;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.smolny.homework_03.model.Book;
import ru.smolny.homework_03.model.Issue;
import ru.smolny.homework_03.model.Reader;
import ru.smolny.homework_03.repository.BookRepository;
import ru.smolny.homework_03.repository.IssueRepository;
import ru.smolny.homework_03.repository.ReaderRepository;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    @Bean
    CommandLineRunner initTestData() {
        return args -> {
            Book book1 = bookRepository.save(new Book("Война и Мир"));
            Book book2 = bookRepository.save(new Book("Мертвые души"));
            Book book3 = bookRepository.save(new Book("Философия JAVA"));

            Reader reader1 = readerRepository.save(new Reader("Андрей"));
            Reader reader2 = readerRepository.save(new Reader("Дарья"));
            Reader reader3 = readerRepository.save(new Reader("Николай"));

            issueRepository.save(new Issue(book2, reader1));
            issueRepository.save(new Issue(book1, reader2));
            issueRepository.save(new Issue(book3, reader1));
        };
    }
}
