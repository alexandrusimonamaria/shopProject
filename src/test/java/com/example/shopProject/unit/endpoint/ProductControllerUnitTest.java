package com.example.shopProject.unit.endpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.controller.ProductController;
import org.example.dto.DiscountDto;
import org.example.dto.ProductDto;
import org.example.dto.StockDto;
import org.example.mapper.ProductMapper;
import org.example.model.Product;
import org.example.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductControllerUnitTest {
    private MockMvc mockMvc;
    @Mock
    private ProductService productService;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testGetAll_Success() throws Exception {
        List<ProductDto> products = getDummyProductsDtos();
        Mockito.when(productService.getAll()).thenReturn(products);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/product"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(products)));
    }

    @Test
    public void testDelete_Success() throws Exception {
        ProductDto productDto = getDummyStudentDtoOne();
        productService.delete(productDto.getId());

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/product/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(productDto)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testSave_Success() throws Exception {
        ProductDto productDto = getDummyStudentDtoOne();
        productDto.setId(null);
        ProductDto savedProduct = getDummyStudentDtoOne();

        Mockito.when(productService.saveProduct(productDto))
                .thenReturn(savedProduct);


        mockMvc.perform(MockMvcRequestBuilders
                        .post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(productDto)))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //.andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(savedProduct)));
    }

    @Test
    public void testPut_Success() throws Exception {
        ProductDto productDto = getDummyStudentDtoOne();

        ProductDto updatedProduct = getDummyStudentDtoTwo();

        productService.updateProduct(productDto.getId(), productMapper.map(productDto));

//        Mockito.when(productService.updateProduct(productDto.getId(), productDto))
//                .thenReturn(updatedProduct);

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/product/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(productDto)))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //.andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(savedProduct)));
    }

    private List<ProductDto> getDummyProductsDtos() {
        return new ArrayList<>(Arrays.asList(getDummyStudentDtoOne(), getDummyStudentDtoTwo()));
    }

    private ProductDto getDummyStudentDtoOne() {
        ProductDto productDto = new ProductDto();
        productDto.setId(1);
        productDto.setProductName("Cat");
        productDto.setProductPrice(33);
        productDto.setProductDescription("toy");
        productDto.setProductStock(new StockDto());
        productDto.setDiscountProduct(new DiscountDto());

        return productDto;
    }

    private ProductDto getDummyStudentDtoTwo() {
        ProductDto productDto = new ProductDto();
        productDto.setId(2);
        productDto.setProductName("Monkey");
        productDto.setProductPrice(35);
        productDto.setProductDescription("toy");
        productDto.setProductStock(new StockDto());
        productDto.setDiscountProduct(new DiscountDto());

        return productDto;
    }
}
