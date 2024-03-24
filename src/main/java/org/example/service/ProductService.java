package org.example.service;

import org.example.dto.ProductDto;
import org.example.exception.ProductNotFoundException;
import org.example.mapper.ProductMapper;
import org.example.model.Product;
import org.springframework.stereotype.Service;
import org.example.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;;

@Service
public class ProductService {
    private final ProductRepository productsRepository;
    private final ProductMapper productMapper;


    public ProductService(ProductRepository productsRepository, ProductMapper productMapper) {
        this.productsRepository = productsRepository;
        this.productMapper = productMapper;
    }

    public ProductDto saveProduct(ProductDto productDto) {
        Product dbProduct = productsRepository.save(productMapper.map(productDto));
        return productMapper.map(dbProduct);
    }

    public void delete(Integer id) {
        productsRepository.deleteById(id);
    }

    public ProductDto getProduct(Integer id) {
        Product product = productsRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product " + id + "doesn't exist."));
        return productMapper.map(product);
    }

    public List<ProductDto> getAll() {
        List<Product> allProduct = productsRepository.findAll();
        return productMapper.mapListToProductDto(allProduct);
    }

    public void updateProduct(Integer id, Product newProduct) {
        productsRepository.findById(id).map(dbProduct -> {
            if (dbProduct.getId().equals(id)) {
                if (newProduct.getProductName() != null) {
                    dbProduct.setProductName(newProduct.getProductName());
                }
                if (newProduct.getProductPrice() != null) {
                    dbProduct.setProductPrice(newProduct.getProductPrice());
                }
                if (newProduct.getProductDescription() != null) {
                    dbProduct.setProductDescription(newProduct.getProductDescription());
                }
            }
            return productsRepository.save(newProduct);
        });
    }
}
