package ru.abondin.jokerconf2019.tddd.producer;


import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;

@Import(ReceiptHttpConfiguration.class)
// TODO Exclude database initialization
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public abstract class BaseReceiptContractTest {

    @LocalServerPort
    private int port;

    @MockBean
    private ReceiptRepository receiptRepository;

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;

        System.err.println("-------------------- " + port);

        Mockito.when(receiptRepository.findAll())
                .thenReturn(Flux.just(new Receipt("20020wofbf", "5260307811", new BigDecimal(100.00))));
    }

}
