package ru.abondin.jokerconf2019.tddd.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;

@WebFluxTest
@Import(ReceiptHttpConfiguration.class)
@RunWith(SpringRunner.class)
public class ReceiptHttpTest {

    @MockBean
    private ReceiptRepository receiptRepository;


    @Autowired
    private WebTestClient webClient;

    @Test
    public void getAllReceipts() {

        Mockito.when(receiptRepository.findAll())
                .thenReturn(Flux.just(new Receipt("20020wofbf", "5260307811", new BigDecimal(100.00))));

        webClient
                .get()
                .uri("/receipts")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody().jsonPath("@.[0].taxpayerInn", "5260307811").exists();
    }
}
