package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.example.model.Client;

@Getter
@Setter
public class OrderDto {
    private Integer id;
    @NotNull(message = "Product name is mandatory.")
    @NotBlank(message = "Product name must have a value.")
    private String productNameOrder;
    @NotNull(message = "Product price is mandatory.")
    @NotBlank(message = "Product price must have a value.")
    private Integer productPriceOrder;

    private Client client;

}
