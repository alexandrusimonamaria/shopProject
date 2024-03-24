package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiscountDto {
    private Integer id;
    private String nameProd;
    private double priceProd;
    private double percentageProd;

}
