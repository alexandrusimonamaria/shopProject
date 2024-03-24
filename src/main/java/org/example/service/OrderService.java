package org.example.service;

import org.example.dto.OrderDto;
import org.example.mapper.OrderMapper;
import org.example.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orderMapper.mapListToOrderDto(orders);
    }

    public OrderDto saveOrder(OrderDto orderDto) {
        Order dbOrder = orderRepository.save(orderMapper.map(orderDto));
        return orderMapper.map(dbOrder);
    }

    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }
}
