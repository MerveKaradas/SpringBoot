package com.doyur.demo.controller1;

import com.doyur.demo.model.OrderStatus;
import com.doyur.demo.service.abstracts.OrderStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/order-status")
public class OrderStatusController {

    private OrderStatusService orderStatusService;

    public OrderStatusController(OrderStatusService orderStatusService) {
        this.orderStatusService = orderStatusService;
    }

    @GetMapping("/all-order-status")
    public ResponseEntity<List<OrderStatus>> getAllOrderStatus() {
        return ResponseEntity.ok(orderStatusService.getAllOrderStatus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderStatus> getOrderStatusById(int id) {
        return ResponseEntity.ok(orderStatusService.findOrderStatusById(id));
    }

    @PostMapping("/create-order-status")
    public ResponseEntity<OrderStatus> createOrderStatus(@RequestBody OrderStatus orderStatus) {
        OrderStatus newOrderStatus = orderStatusService.saveOrderStatus(orderStatus);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrderStatus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderStatus> updateOrderStatus(@PathVariable int id, @RequestBody OrderStatus orderStatus) {
        return ResponseEntity.ok(orderStatusService.updateOrderStatus(id, orderStatus));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderStatus(@PathVariable int id) {
        orderStatusService.deleteOrderStatus(id);
        return ResponseEntity.noContent().build();
    }
}
