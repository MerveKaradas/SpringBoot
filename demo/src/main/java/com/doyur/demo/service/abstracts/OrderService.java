package com.doyur.demo.service.abstracts;

import com.doyur.demo.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    Order findOrderById(int id);

    Order saveOrder(Order order);

    Order updateOrder(int id, Order order);

    void deleteOrder(int id);
}
