package ru.smolny.lection_11.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MyService {
    private final Counter counter;
    private final Timer timer;


    public MyService(MeterRegistry meterRegistry) {
        counter = Counter.builder("my_custom_counter")
                .description("Counts something very important")
                .register(meterRegistry);
        timer = Timer.builder("my_custom_timer")
                .description("Counts something important")
                .register(meterRegistry);
    }

    public void doSomethingImportant() {
        counter.increment();
    }

    public void doSomethingTimed() {
        timer.record(() -> {
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
