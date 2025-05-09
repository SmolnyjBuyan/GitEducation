package ru.smolny.lection_11.api;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smolny.lection_11.service.MyService;

@RestController
@RequiredArgsConstructor
public class MyController {
    private final MeterRegistry meterRegistry;
    private final MyService myService;

    @GetMapping("/hello")
    public String sayHello() {
        meterRegistry.counter("requests_to_hello").increment();
        return "Hello, World";
    }

    @GetMapping("/counter")
    public String doSomethingImportant() {
        myService.doSomethingImportant();
        return "It's counted";
    }

    @GetMapping("/timer")
    public String doSomethingTimed() {
        myService.doSomethingTimed();
        return "It's timed";
    }
}
