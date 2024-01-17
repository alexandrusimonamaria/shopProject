package org.example.controller;

import org.example.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDto> getAll() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public OrderDto saveOrder(@RequestBody OrderDto orderDto) {
        return orderService.saveOrder(orderDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        orderService.delete(id);
    }
}

