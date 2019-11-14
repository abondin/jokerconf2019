package ru.abondin.jokerconf2019.tdddclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {
    private String uuid;
    private String taxpayerInn;
    private BigDecimal amount;
}
