package org.example.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
>>>>>>> 80521185f4deca86ce82f3e92497b67390b750be

@Getter
@Setter
public class ProductDto implements Serializable {
    private Integer id;
    @NotNull(message = "Product name is mandatory.")
    @NotBlank(message = "Product name must have a value.")
    private String productName;
    @NotNull(message = "Price is mandatory.")
    @Min(value = 1, message = "Price can be min 1.")
    private Integer productPrice;
    private String productDescription;

    private StockDto productStock;
    private DiscountDto discountProduct;

<<<<<<< HEAD

=======
>>>>>>> 80521185f4deca86ce82f3e92497b67390b750be
}
