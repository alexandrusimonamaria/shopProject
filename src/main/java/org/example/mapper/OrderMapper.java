package org.example.mapper;

import org.example.dto.OrderDto;
import org.example.model.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {


    public List<OrderDto> mapListToOrderDto(List<Order> orders) {
        return orders.stream()
                .map(order -> map(order))
                .collect(Collectors.toList());
    }

    public List<Order> mapListToOrder(List<OrderDto> ordersDtos) {
        return ordersDtos.stream()
                .map(ordersDto -> map(ordersDto))
                .collect(Collectors.toList());
    }

    public OrderDto map(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setProductNameOrder(order.getProductNameOrder());
        orderDto.setProductPriceOrder(order.getProductPriceOrder());
        return orderDto;
    }

    public Order map(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setProductNameOrder(orderDto.getProductNameOrder());
        order.setProductPriceOrder(orderDto.getProductPriceOrder());
        return order;
    }
}
