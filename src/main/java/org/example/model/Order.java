package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "product_name_ord")
    private String productNameOrder;
    @Column(name = "product_price_ord")
    private Integer productPriceOrder;

    @ManyToOne
    @JoinColumn(name = "client_id" )
    private Client client;
}
