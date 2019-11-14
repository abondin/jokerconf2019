package ru.abondin.jokerconf2019.tdddclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;


//TODO Random port
@AutoConfigureStubRunner(ids = "ru.abondin.jokerconf2019:tddd-producer:+8080",
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
@RunWith(SpringRunner.class)
@SpringBootTest
public class TdddClientApplicationTests {

    @Autowired
    private ReceiptClient client;

    @Test
    public void contextLoads() {

        Flux<Receipt> allReceipts = client.getAllReceipts();
        StepVerifier
                .create(allReceipts)
                .expectNextMatches(receipt -> receipt.getUuid() != null && "5260307811".equals(receipt.getTaxpayerInn()))
                .verifyComplete();
    }

}
