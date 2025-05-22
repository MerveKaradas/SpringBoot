package com.doyur.demo.service.abstracts;

import com.doyur.demo.model.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> getAllOrderItems();

    OrderItem findOrderItemById(int id);

    OrderItem saveOrderItem(OrderItem orderItem);

    OrderItem updateOrderItem(int id, OrderItem orderItem);

    void deleteOrderItem(int id);
}
