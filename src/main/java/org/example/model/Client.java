package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "no_order")
    private Integer noOrder;
    @Column(name = "product_ordered")
    private String productName;
    @Column(name = "product_price")
    private Integer productPrice;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

}
