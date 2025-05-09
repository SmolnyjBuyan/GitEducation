package ru.smolny.homework_03.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import ru.smolny.homework_03.model.Book;
import ru.smolny.homework_03.repository.BookRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
class BookRestControllerTest {
    private final String API_BOOK_URI = "/api/book";

    @Autowired
    WebTestClient webTestClient;

    @Autowired
    BookRepository bookRepository;

    @AfterEach
    void cleanUp() {
        bookRepository.deleteAll();
    }

    @Test
    void getById_ShouldReturnBook() {
        Book savedBook = bookRepository.save(new Book("JUnitBook"));

        webTestClient.get()
                .uri(API_BOOK_URI + "/{id}", savedBook.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(JUnitBookResponse.class)
                .isEqualTo(new JUnitBookResponse(
                        savedBook.getId(),
                        savedBook.getTitle()
                ));
    }

    @Test
    void getNonExistentById_ShouldReturnNotFound() {
        webTestClient.get()
                .uri(API_BOOK_URI + "/{id}", Long.MAX_VALUE)
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void getById_WithInvalidId_ShouldReturnBadRequest() {
        webTestClient.get()
                .uri(API_BOOK_URI + "/-1")
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void deleteById_ShouldRemoveBook() {
        Book bookToDelete = bookRepository.save(new Book("JUnitBook"));

        webTestClient.delete()
                .uri(API_BOOK_URI + "/{id}", bookToDelete.getId())
                .exchange()
                .expectStatus().isNoContent();

        assertThat(bookRepository.existsById(bookToDelete.getId())).isFalse();
    }

    @Test
    void deleteById_WithInvalidId_ShouldReturnBadRequest() {
        webTestClient.delete()
                .uri(API_BOOK_URI + "/-1")
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void create_ShouldPersistAndReturnBook() {
        JUnitBookRequest bookRequest = new JUnitBookRequest("JUnitBook");

        JUnitBookResponse bookResponse = webTestClient.post()
                .uri(API_BOOK_URI)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(bookRequest)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(JUnitBookResponse.class)
                .returnResult()
                .getResponseBody();

        List<Book> books = bookRepository.findAll();
        assertThat(books).hasSize(1);
        Book createdBook = books.get(0);
        assertThat(bookResponse).isEqualTo(new JUnitBookResponse(
                createdBook.getId(),
                createdBook.getTitle()
        ));
    }

    @Test
    void create_WithInvalidTitle_ShouldReturnBadRequest() {
        JUnitBookRequest invalidBookRequest = new JUnitBookRequest("");

        webTestClient.post()
                .uri(API_BOOK_URI)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(invalidBookRequest)
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Data
    @AllArgsConstructor
    static class JUnitBookResponse {
        private long id;
        private String title;
    }

    @Data
    @AllArgsConstructor
    static class JUnitBookRequest {
        private String title;
    }
}