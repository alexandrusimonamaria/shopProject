package com.example.shopProject.unit.service;

import org.example.dto.ProductDto;
import org.example.mapper.ProductMapper;
import org.example.model.Product;
import org.example.repository.ProductRepository;
import org.example.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;


public class ProductServiceUnitTest {
    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetById_success() {
        Product product = getDummyStudent();
        ProductDto productDto = getDummyStudentDtoOne();

        Mockito.when(productRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(product));
        Mockito.when(productMapper.map(product))
                .thenReturn(productDto);

        ProductDto returnedProduct = productService.getProduct(1);

        Assertions.assertEquals(returnedProduct.getProductName(), productDto.getProductName());
        Assertions.assertEquals(returnedProduct.getProductPrice(), productDto.getProductPrice());
        Assertions.assertEquals(returnedProduct.getProductDescription(), productDto.getProductDescription());
    }

    @Test
    public void testSave_Success() {
        Product product = getDummyStudent();
        ProductDto productDto = getDummyStudentDtoOne();

        Mockito.when(productRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(product));
        Mockito.when(productMapper.map(product))
                .thenReturn(productDto);

        ProductDto savedProduct =  productService.saveProduct(productDto);

        Assertions.assertEquals(savedProduct.getProductName(), productDto.getProductName());
        Assertions.assertEquals(savedProduct.getProductPrice(), productDto.getProductPrice());
        Assertions.assertEquals(savedProduct.getProductDescription(), productDto.getProductDescription());
    }

    @Test
    public void testDelete_Success() {
        Product product = getDummyStudent();
        ProductDto productDto = getDummyStudentDtoOne();

        Mockito.when(productRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(product));
        Mockito.when(productMapper.map(product))
                .thenReturn(productDto);

        productService.delete(2);

        Mockito.verify(productRepository)
                .deleteById(eq(getDummyStudentDtoOne().getId()));
    }

    @Test
    public void testPut_Success() {
        Product product = getDummyStudent();
        ProductDto newProduct = new ProductDto();
        newProduct.setId(1);
        newProduct.setProductName("Monkey");
        newProduct.setProductPrice(33);
        newProduct.setProductDescription("toy");

        Mockito.when(productRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(product));
        Mockito.when(productMapper.map(product))
                .thenReturn(newProduct);

        productService.updateProduct(product.getId(), new Product());
    }

    private Product getDummyStudent() {
        Product product = new Product();
        product.setId(1);
        product.setProductName("Cat ");
        product.setProductPrice(33);
        product.setProductDescription("toy");
        return product;
    }

    private ProductDto getDummyStudentDtoOne() {
        ProductDto productDto = new ProductDto();
        productDto.setId(2);
        productDto.setProductName("Cat ");
        productDto.setProductPrice(33);
        productDto.setProductDescription("toy");

        return productDto;
    }


}
