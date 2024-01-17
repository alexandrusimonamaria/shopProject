package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "date_transaction")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date = LocalDateTime.now();
    @Column(name = "total_amount")
    private double totalAmount;

    @OneToOne
    private Client client;

    // private List<Product> purchasedItems;

}
