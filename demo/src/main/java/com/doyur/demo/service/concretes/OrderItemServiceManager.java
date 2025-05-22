package com.doyur.demo.service.concretes;

import com.doyur.demo.model.OrderItem;
import com.doyur.demo.repository.abstracts.OrderItemRepository;
import com.doyur.demo.service.abstracts.OrderItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemServiceManager implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemServiceManager(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }


    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem findOrderItemById(int id) {
        return orderItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("OrderItem not found"));
    }

    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
      /*  Optional<OrderItem> orderItemOptional = orderItemRepository.findByOrderItemId(orderItem.getOrderItemId());
        if (orderItemOptional.isPresent()) {
            throw new IllegalArgumentException("OrderItem already exists");
        } */
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem updateOrderItem(int id, OrderItem orderItem) {
        OrderItem orderItemToUpdate = orderItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("OrderItem not found"));

        orderItemToUpdate.setQuantity(orderItem.getQuantity());

        return orderItemRepository.save(orderItemToUpdate);
    }

    @Override
    public void deleteOrderItem(int id) {
        Optional<OrderItem> orderItemOptional = orderItemRepository.findById(id);
        if (orderItemOptional.isPresent()) {
            orderItemRepository.deleteById(id);
        }
        else {
            throw new IllegalArgumentException("OrderItem not found");
        }
    }
}
