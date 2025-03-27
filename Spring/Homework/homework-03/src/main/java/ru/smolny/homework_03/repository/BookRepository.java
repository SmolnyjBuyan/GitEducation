package ru.smolny.homework_03.repository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.smolny.homework_03.model.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private final List<Book> books;

    public BookRepository() {
        books = new ArrayList<>();
    }

    @PostConstruct
    private void generateData() {
        books.addAll(List.of(
                new Book("Война и Мир"),
                new Book("Мертвые души"),
                new Book("Философия JAVA")
        ));
    }

    public Book getBookById(long id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

}
