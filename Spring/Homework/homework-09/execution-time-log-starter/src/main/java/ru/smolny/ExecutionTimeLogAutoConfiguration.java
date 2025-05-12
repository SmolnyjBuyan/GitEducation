package ru.smolny;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ExecutionTimeLogProperties.class)
public class ExecutionTimeLogAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ExecutionTimeLogAspect executionTimeLogAspect(ExecutionTimeLogProperties properties) {
        return new ExecutionTimeLogAspect(properties);
    }
}
