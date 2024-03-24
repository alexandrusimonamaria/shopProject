package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "discount_product")
    private String nameProd;
    @Column(name = "discount_price")
    private double priceProd;
    @Column(name = "discount_percentage")
    private double percentageProd;

    @OneToOne
    private Product product;
}
