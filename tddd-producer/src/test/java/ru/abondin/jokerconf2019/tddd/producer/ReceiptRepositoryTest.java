package ru.abondin.jokerconf2019.tddd.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

@DataR2dbcTest
@RunWith(SpringRunner.class)
public class ReceiptRepositoryTest {

    @Autowired
    private ReceiptRepository repository;

    @Test
    public void persist() {
        Mono<Receipt> stmReceipt = repository.save(new Receipt("20020wofbf", "5260307811", new BigDecimal(100.00)));
        StepVerifier
                .create(stmReceipt)
                .expectNextMatches(r -> "20020wofbf".equals(r.getUuid()))
                .verifyComplete();
    }

}
