package ru.smolny.homework_03.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smolny.homework_03.dto.BookResponse;
import ru.smolny.homework_03.exception.BookAlreadyExistsException;
import ru.smolny.homework_03.exception.BookNotFoundException;
import ru.smolny.homework_03.mapper.BookMapper;
import ru.smolny.homework_03.model.Book;
import ru.smolny.homework_03.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book getById(long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    public Book create(String title) {
        if (bookRepository.existsByTitleIgnoreCase(title)) throw new BookAlreadyExistsException(title);
        return bookRepository.save(new Book(title));
    }
}
