package com.example.shopProject.unit.endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.controller.DiscountController;
import org.example.dto.DiscountDto;
import org.example.service.DiscountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiscountControllerUnitTest {
    private MockMvc mockMvc;

    @Mock
    private DiscountService discountService;

    @InjectMocks
    private DiscountController discountController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(discountController).build();
    }

    @Test
    public void testGetAll_Success() throws Exception {
        List<DiscountDto> discounts = getDummyDiscountDtos();
        Mockito.when(discountService.getAll()).thenReturn(discounts);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/discount"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(discounts)));
    }

    private List<DiscountDto> getDummyDiscountDtos() {
        return new ArrayList<>(Arrays.asList(getDummyDiscountDtoOne(), getDummyDiscountDtoTwo()));
    }


    private DiscountDto getDummyDiscountDtoOne() {
        DiscountDto discountDto = new DiscountDto();
        discountDto.setId(1);
        discountDto.setNameProd("Cat");
        discountDto.setPercentageProd(3.0);

        return discountDto;
    }

    private DiscountDto getDummyDiscountDtoTwo() {
        DiscountDto discountDto = new DiscountDto();
        discountDto.setId(2);
        discountDto.setNameProd("Monkey");
        discountDto.setPercentageProd(5.0);

        return discountDto;
    }

}
