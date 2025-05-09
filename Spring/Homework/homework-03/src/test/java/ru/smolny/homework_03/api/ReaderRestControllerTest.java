package ru.smolny.homework_03.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.transaction.annotation.Transactional;
import ru.smolny.homework_03.TestDataInitializer;
import ru.smolny.homework_03.dto.ReaderResponse;
import ru.smolny.homework_03.model.*;
import ru.smolny.homework_03.repository.BookRepository;
import ru.smolny.homework_03.repository.IssueRepository;
import ru.smolny.homework_03.repository.RoleRepository;
import ru.smolny.homework_03.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
    @Autowired
    private TestDataInitializer testData;

    @BeforeEach
    void setUp() {
        testData.cleanAll();
        testData.initData();
    }

    @AfterAll
    void cleanUp() {
        testData.cleanAll();
    }

    @Test
    void testGetByIdSuccess() {
        User wise = testData.getWise();
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
        List<User> users = testData.getUsers();
        List<JUnitReaderResponse> responseBody = webTestClient.get()
                .uri(READER_API_URL)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(JUnitReaderResponse.class)
                .hasSize(users.size())
                .returnResult()
                .getResponseBody();

        assertThat(responseBody).isNotNull();
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
        User wise = testData.getWise();
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
        List<User> users = testData.getUsers();
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
        User wise = testData.getWise();
        List<Issue> wiseIssues = testData.getIssues().stream().filter(issue -> issue.getUser().equals(wise)).toList();
        List<JUnitResponseIssue> expectedResponseIssues = wiseIssues.stream().map(this::createExpectedIssue).toList();

        List<JUnitResponseIssue> responseIssues = webTestClient.get()
                .uri(READER_API_URL + "/{id}/issue", wise.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(JUnitResponseIssue.class)
                .hasSize(wiseIssues.size())
                .returnResult()
                .getResponseBody();

        assertThat(responseIssues)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFieldsOfTypes(LocalDateTime.class)
                .ignoringCollectionOrder()
                .isEqualTo(expectedResponseIssues);
    }

    private JUnitResponseIssue createExpectedIssue(Issue issue) {
        JUnitResponseIssue expected = new JUnitResponseIssue();
        expected.setId(issue.getId());
        expected.setBookId(issue.getBook().getId());
        expected.setBookTitle(issue.getBook().getTitle());
        expected.setReaderId(issue.getUser().getId());
        expected.setReaderName(issue.getUser().getUsername());
        expected.setIssueDate(issue.getIssueDate());
        expected.setReturnDate(issue.getReturnDate());
        return expected;
    }

    @Test
    void testGetIssuesByReaderIdValidationFail() {
        webTestClient.get()
                .uri(READER_API_URL + "/{id}/issue", -1)
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void testGetIssuesByReaderIdNotFound() {
        webTestClient.get()
                .uri(READER_API_URL + "/{id}/issue", Long.MAX_VALUE)
                .exchange()
                .expectStatus().isNotFound();
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
        private long readerId;
        private String readerName;
        private LocalDateTime issueDate;
        private LocalDateTime returnDate;
    }
}