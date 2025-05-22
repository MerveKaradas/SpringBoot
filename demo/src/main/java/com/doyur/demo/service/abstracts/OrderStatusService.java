package com.doyur.demo.service.abstracts;

import com.doyur.demo.model.OrderStatus;

import java.util.List;

public interface OrderStatusService {
    List<OrderStatus> getAllOrderStatus();

    OrderStatus findOrderStatusById(int id);

    OrderStatus saveOrderStatus(OrderStatus orderStatus);

    OrderStatus updateOrderStatus(int id, OrderStatus orderStatus);

    void deleteOrderStatus(int id);
}
