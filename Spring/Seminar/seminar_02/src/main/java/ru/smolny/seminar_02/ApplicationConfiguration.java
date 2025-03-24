package ru.smolny.seminar_02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ApplicationConfiguration {
    @Bean
    UserRepository myUserRepository() {
        return new UserRepository();
    }
}
