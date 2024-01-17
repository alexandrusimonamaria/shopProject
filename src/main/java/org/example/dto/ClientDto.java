package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ClientDto {
    private Integer id;
    private Integer noOrder;
    @NotNull(message = "Product name is mandatory.")
    @NotBlank(message = "Product name must have a value.")
    private String productName;
    @NotNull(message = "Product price is mandatory.")
    @NotBlank(message = "Product price must have a value.")
    private Integer productPrice;

}
