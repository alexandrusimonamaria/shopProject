package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.model.Client;

import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionDto {
    private Integer id;
    private LocalDateTime date = LocalDateTime.now();
    // private Client client;
    // private List<Product> purchasedItems;
    private double totalAmount;

    private Client clientId;
}
