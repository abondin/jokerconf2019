package ru.abondin.jokerconf2019.tdddclient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Component
public class ReceiptClient {

    private final WebClient webClient;

    Flux<Receipt> getAllReceipts() {
        return webClient
                .get()
                .uri("http://localhost:8080/receipts")
                .retrieve()
                .bodyToFlux(Receipt.class);
    }

}
