package ru.abondin.jokerconf2019.tddd.producer;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ReceiptRepository extends ReactiveCrudRepository<Receipt, String> {
}
