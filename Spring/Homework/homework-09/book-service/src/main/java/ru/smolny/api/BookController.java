package ru.smolny.api;

import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smolny.model.Author;
import ru.smolny.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/book")
public class BookController {
    private final List<Book> books;
    private final Faker faker;

    public BookController() {
        final List<Book> books = new ArrayList<>();
        this.faker = new Faker();

        for (int i = 0; i < 15; i++) {
            Author author = new Author();
            author.setId(UUID.randomUUID());
            author.setFirstName(faker.name().firstName());
            author.setLastName(faker.name().lastName());

            Book book = new Book();
            book.setId(UUID.randomUUID());
            book.setTitle(faker.name().title());
            book.setAuthor(author);

            books.add(book);
        }

        this.books = List.copyOf(books);
    }

    @GetMapping
    public List<Book> getAll() {
        return books;
    }

    @GetMapping("/random")
    public Book getRandom() {
        int randomIndex = faker.number().numberBetween(0, books.size());
        return books.get(randomIndex);
    }


}
