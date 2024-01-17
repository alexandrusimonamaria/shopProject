package com.example.shopProject.unit.endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.controller.StockController;
import org.example.dto.StockDto;
import org.example.service.StockService;
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

public class StockControllerUnitTest {

    private MockMvc mockMvc;

    @Mock
    private StockService stockService;

    @InjectMocks
    private StockController stockController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(stockController).build();
    }

    @Test
    public void testGetAll_Success() throws Exception {
        List<StockDto> stocks = getDummyStockDtos();
        Mockito.when(stockService.getAll()).thenReturn(stocks);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/stock"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(stocks)));
    }
    private List<StockDto> getDummyStockDtos() {
        return new ArrayList<>(Arrays.asList(getDummyStockDtoOne(), getDummyStockDtoTwo()));
    }

    private StockDto getDummyStockDtoOne() {
        StockDto stockDto = new StockDto();
        stockDto.setId(1);
        stockDto.setProductStock("Cat");
        stockDto.setPriceStock(33);

        return stockDto;
    }

    private StockDto getDummyStockDtoTwo() {
        StockDto stockDto = new StockDto();
        stockDto.setId(2);
        stockDto.setProductStock("Monkey");
        stockDto.setPriceStock(35);

        return stockDto;
    }

}
