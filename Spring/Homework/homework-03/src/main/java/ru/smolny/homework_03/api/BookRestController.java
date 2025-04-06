package ru.smolny.homework_03.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.smolny.homework_03.dto.BookRequest;
import ru.smolny.homework_03.dto.BookResponse;
import ru.smolny.homework_03.service.BookService;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/book")
@Validated
public class BookRestController {
    private final BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getById(@PathVariable @Min(value = 1) long id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable @Min(value = 1) long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<BookResponse> create(
            @Valid @RequestBody BookRequest request, UriComponentsBuilder uriBuilder) {
        BookResponse bookResponse = bookService.create(request.getTitle().trim());
        URI uri = uriBuilder.path("/book/{id}").buildAndExpand(bookResponse.getId()).toUri();
        return ResponseEntity.created(uri).body(bookResponse);
    }
}
