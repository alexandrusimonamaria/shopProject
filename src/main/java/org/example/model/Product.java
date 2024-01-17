package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_price")
    private Integer productPrice;
    @Column(name = "product_description")
    private String productDescription;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_stock")
    private Stock stock;

    @OneToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    public Product() {}

    public Product(String productName, Integer productPrice, String productDescription) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }

    public Product(Integer id, String productName, Integer productPrice, String productDescription) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }

}
