package ru.smolny.homework_03.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import ru.smolny.homework_03.dto.UserRequest;
import ru.smolny.homework_03.model.Role;
import ru.smolny.homework_03.model.RoleType;
import ru.smolny.homework_03.model.User;
import ru.smolny.homework_03.repository.RoleRepository;
import ru.smolny.homework_03.repository.UserRepository;
import ru.smolny.homework_03.service.ReaderService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureWebTestClient
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ReaderRestControllerTest {
    @Autowired
    WebTestClient webTestClient;
    @Autowired
    ReaderService readerService;
    @Autowired
    RoleRepository roleRepository;

    @BeforeAll
    void createRoles() {
        Role reader = Role.ofName(RoleType.READER);
        Role admin = Role.ofName(RoleType.ADMIN);
        roleRepository.save(reader);
        roleRepository.save(admin);
    }

    @BeforeEach
    void setUp() {
        readerService.create(new UserRequest("andrey", "1234", "Андрей"));
        readerService.create(new UserRequest("darya", "1234", "Дарья"));
        readerService.create(new UserRequest("nikolay", "1234", "Николай"));
    }

    @Test
    void testGetAll() {

    }

}