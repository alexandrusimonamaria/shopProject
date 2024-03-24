package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "quantity_stock")
    private Integer quantityStock;
    @Column(name = "product_stock ")
    private String productStock;
    @Column(name = "price_stock")
    private Integer priceStock;

    @OneToOne(mappedBy = "stock")
    @JoinColumn(name = "product_id")
    private Product product;

}
