package ru.smolny.homework_03.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import ru.smolny.homework_03.dto.ReaderResponse;
import ru.smolny.homework_03.model.*;
import ru.smolny.homework_03.repository.BookRepository;
import ru.smolny.homework_03.repository.IssueRepository;
import ru.smolny.homework_03.repository.RoleRepository;
import ru.smolny.homework_03.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ReaderRestControllerTest {
    private static final String READER_API_URL = "/api/reader";

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private IssueRepository issueRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private Role reader = Role.ofName(RoleType.READER);
    private Role admin = Role.ofName(RoleType.ADMIN);

    private User nice, wise, dice;
    private Book red, sky, cyan;
    private Issue redIssue, skyIssue, cyanIssue;
    private List<User> users;
    private List<Book> books;
    private List<Issue> issues;

    private void initTestData() {
        red = new Book("Red");
        sky = new Book("Sky");
        cyan = new Book("Cyan");
        books = List.of(red, sky, cyan);

        nice = User.builder()
                .username("nice")
                .password(passwordEncoder.encode("1234"))
                .firstname("Найс")
                .roles(Set.of(reader))
                .build();
        wise = User.builder()
                .username("wise")
                .password(passwordEncoder.encode("1234"))
                .firstname("Вайс")
                .roles(Set.of(reader))
                .build();
        dice = User.builder()
                .username("dice")
                .password(passwordEncoder.encode("1234"))
                .firstname("Дайс")
                .roles(Set.of(reader))
                .build();
        users = List.of(nice, wise, dice);

        redIssue = new Issue(red, wise);
        skyIssue = new Issue(sky, wise);
        cyanIssue = new Issue(cyan, dice);
        issues = List.of(redIssue, skyIssue, cyanIssue);
    }

    @BeforeAll
    void createRoles() {
        roleRepository.save(reader);
        roleRepository.save(admin);
    }

    @BeforeEach
    void setUp() {
        initTestData();
        issueRepository.deleteAll();
        userRepository.deleteAll();
        bookRepository.deleteAll();
        userRepository.saveAll(users);
        bookRepository.saveAll(books);
        issueRepository.saveAll(issues);
    }

    @AfterAll
    void cleanUp() {
        userRepository.deleteAll();
        roleRepository.deleteAll();
    }

    @Test
    void testGetByIdSuccess() {
        JUnitReaderResponse responseBody = webTestClient.get()
                .uri(READER_API_URL + "/{id}", wise.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(JUnitReaderResponse.class)
                .returnResult()
                .getResponseBody();

        assertThat(responseBody).isNotNull();
        assertThat(responseBody.getId()).isEqualTo(wise.getId());
        assertThat(responseBody.getFirstname()).isEqualTo(wise.getFirstname());
    }

    @Test
    void testGetByIdNotFound() {
        webTestClient.get()
                .uri(READER_API_URL + "/{id}", Long.MAX_VALUE)
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testGetByIdValidationFail() {
        webTestClient.get()
                .uri(READER_API_URL + "/{id}", -1)
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void testGetAll() {
        List<JUnitReaderResponse> responseBody = webTestClient.get()
                .uri(READER_API_URL)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(JUnitReaderResponse.class)
                .hasSize(users.size())
                .returnResult()
                .getResponseBody();

        for (JUnitReaderResponse response : responseBody) {
            boolean found = users.stream()
                    .filter(it -> Objects.equals(it.getId(), response.getId()))
                    .anyMatch(it -> Objects.equals(it.getUsername(), response.getUsername())
                            && Objects.equals(it.getFirstname(), response.getFirstname()));
            assertThat(found).isTrue();
        }
    }

    @Test
    void testDeleteById() {
        webTestClient.delete()
                .uri(READER_API_URL + "/{id}", wise.getId())
                .exchange()
                .expectStatus().isNoContent();

        assertThat(userRepository.findById(wise.getId())).isEmpty();
    }

    @Test
    void testDeleteByIdValidationFail() {
        webTestClient.delete()
                .uri(READER_API_URL + "/{id}", -1)
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void testCreateReader() {
        JUnitReaderRequest request = new JUnitReaderRequest("junit","1234", "JunitReader");
        int initialUserCount = users.size();

        ReaderResponse response = webTestClient.post()
                .uri(READER_API_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(ReaderResponse.class)
                .returnResult()
                .getResponseBody();

        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(initialUserCount + 1);
        assertThat(request.getUsername()).isEqualTo(response.getUsername());
        assertThat(request.getFirstname()).isEqualTo(response.getFirstname());

        User newReader = userRepository.findById(initialUserCount + 1L)
                .orElseThrow(() -> new AssertionError("Reader not found in DB"));

        assertThat(request.getUsername()).isEqualTo(newReader.getUsername());
        assertThat(request.getFirstname()).isEqualTo(newReader.getFirstname());
        assertThat(passwordEncoder.matches(request.getPassword(), newReader.getPassword())).isTrue();
    }

    void testCreateReaderValidationFail(JUnitReaderRequest invalidRequest) {
        webTestClient.post()
                .uri(READER_API_URL)
                .bodyValue(invalidRequest)
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void testCreateReaderUsernameValidationFail() {
        testCreateReaderValidationFail(new JUnitReaderRequest("", "1234", "JUnitTest"));
    }

    @Test
    void testCreateReaderPasswordValidationFail() {
        testCreateReaderValidationFail(new JUnitReaderRequest("junit", "", "JUnitTest"));
    }

    @Test
    void testCreateReaderFirstnameValidationFail() {
        testCreateReaderValidationFail(new JUnitReaderRequest("junit", "1234", ""));
    }

    @Test
    void testGetIssuesByReaderId() {
        List<JUnitResponseIssue> responseIssues = webTestClient.get()
                .uri(READER_API_URL + "/{id}/issue", wise.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(JUnitResponseIssue.class)
                .hasSize(2)
                .returnResult()
                .getResponseBody();

        assertThat(responseIssues)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFieldsOfTypes(LocalDateTime.class)
                .ignoringCollectionOrder()
                .isEqualTo(List.of(
                        createExpectedIssue(redIssue, red),
                        createExpectedIssue(skyIssue, sky)
                ));
    }

    private JUnitResponseIssue createExpectedIssue(Issue issue, Book book) {
        JUnitResponseIssue expected = new JUnitResponseIssue();
        expected.setId(issue.getId());
        expected.setBookId(book.getId());
        expected.setBookTitle(book.getTitle());
        expected.setIssueDate(issue.getIssueDate());
        return expected;
    }

    @Data
    static class JUnitReaderResponse {
        private Long id;
        private String username;
        private String firstname;
    }

    @Data
    @AllArgsConstructor
    static class JUnitReaderRequest {
        private String username;
        private String password;
        private String firstname;
    }

    @Data
    static class JUnitResponseIssue {
        private long id;
        private long bookId;
        private String bookTitle;
        private LocalDateTime issueDate;
    }
}