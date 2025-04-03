package ru.smolny.homework_03.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.smolny.homework_03.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OldBookRepository {
    private final List<Book> books;

    public OldBookRepository() {
        books = new ArrayList<>();
    }

//    @PostConstruct
//    private void generateData() {
//        books.addAll(List.of(
//                new Book("Война и Мир"),
//                new Book("Мертвые души"),
//                new Book("Философия JAVA")
//        ));
//    }

    public Optional<Book> getById(long id) {
        return books.stream().filter(book -> book.getId() == id).findFirst();
    }

    public List<Book> getAll() {
        return books;
    }

    public Optional<Book> getByTitle(String title) {
        return books.stream().filter(book -> book.getTitle()
                .equalsIgnoreCase(title)).findFirst();
    }

    public boolean deleteById(long id) {
        return books.removeIf(book -> book.getId() == id);
    }

//    public Book create(String title) {
//        Book book = new Book(title);
//        books.add(book);
//        return book;
//    }
}
