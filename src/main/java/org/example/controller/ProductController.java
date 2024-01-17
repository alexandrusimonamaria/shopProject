package org.example.controller;

import org.example.dto.ProductDto;
import org.example.mapper.ProductMapper;
import org.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping
    public ProductDto saveProduct(@RequestBody ProductDto productDto) {
        return productService.saveProduct(productDto);
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Integer id) {
        return productService.getProduct(id);
    }

    @GetMapping
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        productService.delete(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        productService.updateProduct(id, product);
    }

}
