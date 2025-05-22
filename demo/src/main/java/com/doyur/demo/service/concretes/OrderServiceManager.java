package com.doyur.demo.service.concretes;

import com.doyur.demo.model.Order;
import com.doyur.demo.repository.abstracts.OrderRepository;
import com.doyur.demo.service.abstracts.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceManager implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceManager(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order findOrderById(int id) {
        return orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }

    @Override
    public Order saveOrder(Order order) {

        Optional<Order> orderOptional = orderRepository.findByOrderDate(order.getOrderDate());
        if (orderOptional.isPresent()) {
            return orderOptional.get(); //
        }
        return orderRepository.save(order);
    } //Gelen tarihte aynı sipariş varsa onu döndür yoksa yeni sipariş oluştur

    @Override
    public Order updateOrder(int id, Order order) {
        Order orderToUpdate = orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Order not found"));
        orderToUpdate.setStatus(order.getStatus());

        return orderRepository.save(orderToUpdate); //SİPARİŞİN SADECE DURUMU DEĞİŞİR - HAZIRLANIYOR/TESLİM EDİLDİ GİBİ
    }

    @Override
    public void deleteOrder(int id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            orderRepository.deleteById(id);
        }
        else {
            throw new IllegalArgumentException("Order not found");
        }
    }

}
