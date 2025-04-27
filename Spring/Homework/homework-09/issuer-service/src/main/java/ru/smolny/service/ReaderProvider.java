package ru.smolny.service;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.smolny.model.ReaderResponse;

@Service
public class ReaderProvider {
    private final WebClient webClient;

    public ReaderProvider(ReactorLoadBalancerExchangeFilterFunction filterFunction) {
        webClient = WebClient.builder()
                .filter(filterFunction)
                .build();
    }

    public ReaderResponse getRandomReader() {
        return webClient.get()
                .uri("http://reader-service/api/reader/random")
                .retrieve()
                .bodyToMono(ReaderResponse.class)
                .block();
    }
}
