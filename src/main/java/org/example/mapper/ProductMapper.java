package org.example.mapper;

import org.example.dto.ProductDto;
import org.example.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    private StockMapper stockMapper;
    private DiscountMapper discountMapper;

    public ProductMapper(StockMapper stockMapper, DiscountMapper discountMapper) {
        this.stockMapper = stockMapper;
        this.discountMapper = discountMapper;
    }

    public List<ProductDto> mapListToProductDto(List<Product> products) {
        return products
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    public List<Product> mapListProduct(List<ProductDto> productDtos) {
        return productDtos
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    public Product map(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }

        Product product = new Product();
        product.setId(productDto.getId());
        product.setProductName(productDto.getProductName());
        product.setProductPrice(productDto.getProductPrice());
        product.setProductDescription(productDto.getProductDescription());
        product.setStock(stockMapper.map(productDto.getProductStock()));
        //product.setDiscount(discountMapper.map(productDto.getDiscountProduct()));

        return product;
    }

    public ProductDto map(Product product) {
        if (product == null) {
            return null;
        }

        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setProductName(product.getProductName());
        productDto.setProductPrice(product.getProductPrice());
        productDto.setProductDescription(product.getProductDescription());
        productDto.setProductStock(stockMapper.map(product.getStock()));
        //productDto.setDiscountProduct(discountMapper.map(product.getDiscount()));

        return productDto;
    }
}
