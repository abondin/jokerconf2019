package ru.abondin.jokerconf2019.tddd.producer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Persistent;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Persistent
public class Receipt {
    @Id
    private String uuid;
    private String taxpayerInn;
    private BigDecimal amount;
}
