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
    private final BookMapper mapper;

    public BookResponse getById(long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        return mapper.toBookResponse(book);
    }

    public List<BookResponse> getAll() {
        List<Book> books = bookRepository.findAll();
        return mapper.toReaderResponseList(books);
    }

    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    public BookResponse create(String title) {
        if (bookRepository.existsByTitleIgnoreCase(title)) throw new BookAlreadyExistsException(title);
        Book book = bookRepository.save(new Book(title));
        return mapper.toBookResponse(book);
    }
}
