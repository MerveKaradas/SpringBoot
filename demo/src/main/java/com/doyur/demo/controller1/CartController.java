package com.doyur.demo.controller1;

import com.doyur.demo.model.Menu;
import com.doyur.demo.service.concretes.ShoppingCartServiceManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CartController {

    private final ShoppingCartServiceManager shoppingCartServiceManager;

    public CartController(ShoppingCartServiceManager shoppingCartServiceManager) {
        this.shoppingCartServiceManager = shoppingCartServiceManager;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addItem(@RequestBody Menu item) {
        shoppingCartServiceManager.addItem(item);
        return ResponseEntity.ok("Item added to cart.");
    }

    @PostMapping("/remove")
    public ResponseEntity<String> removeItem(@RequestBody Menu item) {
        shoppingCartServiceManager.removeItem(item);
        return ResponseEntity.ok("Item removed from cart.");
    }

    @GetMapping("/total-price")
    public ResponseEntity<Float> getTotalPrice() {
        float totalPrice = shoppingCartServiceManager.getTotalPrice();
        return ResponseEntity.ok(totalPrice);
    }
}
