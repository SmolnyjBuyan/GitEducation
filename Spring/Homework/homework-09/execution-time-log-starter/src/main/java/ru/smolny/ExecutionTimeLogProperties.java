package ru.smolny;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "execution.time.log")
public class ExecutionTimeLogProperties {
    private boolean enabled = true;
}
