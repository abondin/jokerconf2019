package ru.abondin.jokerconf2019.tddd.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class ReceiptHttpConfiguration {

    @Bean
    RouterFunction<ServerResponse> routes(ReceiptRepository rr){
        return route()
                .GET("receipts", request->ok().body(rr.findAll(), Receipt.class))
                .build();
    }
}
