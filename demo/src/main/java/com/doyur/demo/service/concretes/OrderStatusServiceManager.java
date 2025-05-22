package com.doyur.demo.service.concretes;

import com.doyur.demo.model.OrderStatus;
import com.doyur.demo.repository.abstracts.OrderStatusRepository;
import com.doyur.demo.service.abstracts.OrderStatusService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderStatusServiceManager implements OrderStatusService {

    private final OrderStatusRepository orderStatusRepository;

    public OrderStatusServiceManager(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }


    @Override
    public List<OrderStatus> getAllOrderStatus() {
        return orderStatusRepository.findAll();
    }

    @Override
    public OrderStatus findOrderStatusById(int id) {
        return orderStatusRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("OrderStatus not found"));
    }

    @Override
    public OrderStatus saveOrderStatus(OrderStatus orderStatus) {
        Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findByStatusName(orderStatus.getStatusName());
        if (orderStatusOptional.isPresent()) {
            throw new IllegalArgumentException("OrderStatus already exists");
        }
        return orderStatusRepository.save(orderStatus);
    }

    @Override
    public OrderStatus updateOrderStatus(int id, OrderStatus orderStatus) {
        OrderStatus orderStatusToUpdate = orderStatusRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("OrderStatus not found"));

        orderStatusToUpdate.setStatusName(orderStatus.getStatusName());
        return orderStatusRepository.save(orderStatusToUpdate);
    }

    @Override
    public void deleteOrderStatus(int id) {
        Optional<OrderStatus> orderStatusOptional = orderStatusRepository.findById(id);
        if (orderStatusOptional.isPresent()) {
            orderStatusRepository.deleteById(id);
        }
        else {
            throw new IllegalArgumentException("OrderStatus not found");
        }

    }
}
