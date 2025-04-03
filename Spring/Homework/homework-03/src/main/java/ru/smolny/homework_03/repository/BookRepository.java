package ru.smolny.homework_03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.smolny.homework_03.model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);
    boolean existsByTitleIgnoreCase(String title);
}
