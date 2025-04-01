package ru.smolny.homework_03.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.smolny.homework_03.model.Book;
import ru.smolny.homework_03.service.BookService;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
@Validated
public class BookRestController {
    private final BookService bookService;
    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable @Min(value = 1, message = "ID must be greater than 0") long id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable @Min(value = 1, message = "ID must be greater than 0") long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Book> create(@Valid @RequestBody BookRequest request, UriComponentsBuilder uriBuilder) {
        Book book = bookService.create(request.getTitle());
        URI uri = uriBuilder.path("/book/{id}").buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(uri).body(book);
    }
}
