package com.doyur.demo.controller1;

import com.doyur.demo.model.OrderItem;
import com.doyur.demo.model.Restaurant;
import com.doyur.demo.service.abstracts.OrderItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    private OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderItem>> getAllOrderItems() {
        return ResponseEntity.ok(orderItemService.getAllOrderItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(int id) {
        return ResponseEntity.ok(orderItemService.findOrderItemById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
        OrderItem newOrderItem = orderItemService.saveOrderItem(orderItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrderItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable int id, @RequestBody OrderItem orderItem) {
        return ResponseEntity.ok(orderItemService.updateOrderItem(id, orderItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable int id) {
        orderItemService.deleteOrderItem(id);
        return ResponseEntity.noContent().build();
    }




}
