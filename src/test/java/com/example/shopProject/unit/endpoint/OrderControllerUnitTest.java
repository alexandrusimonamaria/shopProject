package com.example.shopProject.unit.endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.controller.OrderController;
import org.example.dto.OrderDto;
import org.example.mapper.OrderMapper;
import org.example.service.OrderService;
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


public class OrderControllerUnitTest {

    private MockMvc mockMvc;
    @Mock
    private OrderService orderService;

    @Mock
    OrderMapper orderMapper;
    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    public void testGetAll_Success() throws Exception {
        List<OrderDto> orders = getDummyProductsDtos();
        Mockito.when(orderService.getAllOrders()).thenReturn(orders);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/order"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(orders)));
    }

    @Test
    public void testSave_Success() throws Exception {
        OrderDto orderDto = getDummyStudentDtoOne();
        // orderDto.setId(null);
        OrderDto savedOrder = getDummyStudentDtoOne();

        Mockito.when(orderService.saveOrder(orderDto))
                .thenReturn(orderDto);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(orderDto)))
                .andExpect(MockMvcResultMatchers.status().isOk());
                //.andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(savedOrder)));
    }

    private List<OrderDto> getDummyProductsDtos() {
        return new ArrayList<>(Arrays.asList(getDummyStudentDtoOne(), getDummyStudentDtoTwo()));
    }


    private OrderDto getDummyStudentDtoOne() {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(1);
        orderDto.setProductNameOrder("Cat Toy");
        orderDto.setProductPriceOrder(33);
        //orderDto.setClient(orderDto.getClient());

        return orderDto;
    }

    private OrderDto getDummyStudentDtoTwo() {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(2);
        orderDto.setProductNameOrder("Monkey Toy");
        orderDto.setProductPriceOrder(35);
       // orderDto.setClient(orderDto.getClient());

        return orderDto;
    }
}
