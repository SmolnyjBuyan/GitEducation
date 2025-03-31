package ru.smolny.homework_03.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smolny.homework_03.exception.BookAlreadyExistsException;
import ru.smolny.homework_03.exception.BookNotFoundException;
import ru.smolny.homework_03.model.Book;
import ru.smolny.homework_03.repository.BookRepository;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book getById(long id) {
        return bookRepository.getById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    public void deleteById(long id) {
        if (!bookRepository.deleteById(id)) throw new BookNotFoundException(id);
    }

    public Book create(String title) {
        if (bookRepository.getByTitle(title).isPresent()) throw new BookAlreadyExistsException(title);
        return bookRepository.create(title);
    }
}
