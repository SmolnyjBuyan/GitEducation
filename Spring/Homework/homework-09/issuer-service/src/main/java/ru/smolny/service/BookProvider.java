package ru.smolny.service;

import com.netflix.discovery.EurekaClient;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.smolny.model.BookResponse;

@Service
public class BookProvider {
    private final WebClient webClient;
//    private final EurekaClient eurekaClient;

    public BookProvider(EurekaClient eurekaClient, ReactorLoadBalancerExchangeFilterFunction filterFunction) {
        webClient =  WebClient.builder()
                .filter(filterFunction)
                .build();
//        this.eurekaClient = eurekaClient;
    }

    public BookResponse getRandomBook() {
        BookResponse block = webClient.get()
                .uri("http://book-service/api/book/random")
                .retrieve()
                .bodyToMono(BookResponse.class)
                .block();

        return block;
    }
//
//    private String getBookServiceUrl() {
//        Application application = eurekaClient.getApplication("BOOK-SERVICE");
//        List<InstanceInfo> instances = application.getInstances();
//
//        int randomIndex = ThreadLocalRandom.current().nextInt(instances.size());
//        InstanceInfo randomInstance = instances.get(randomIndex);
//        return randomInstance.getHomePageUrl();
//    }


}
