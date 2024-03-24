package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class StockDto {
    private Integer id;
    private Integer quantityStock;
    @NotNull(message = "Product stock is mandatory.")
    @NotBlank(message = "Product stock must have a value.")
    private String productStock;
    @NotNull(message = "Product price stock is mandatory.")
    @NotBlank(message = "Product price stock must have a value.")
    private Integer priceStock;
}
