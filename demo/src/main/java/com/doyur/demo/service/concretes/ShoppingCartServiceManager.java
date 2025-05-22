package com.doyur.demo.service.concretes;

import com.doyur.demo.model.Menu;
import com.doyur.demo.service.abstracts.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartServiceManager implements ShoppingCartService {

    private List<Menu> items = new ArrayList<>();

    public void addItem(Menu item) {
        items.add(item);
    }

    public void removeItem(Menu item) {
        items.remove(item);
    }

    public List<Menu> getItems() {
        return items;
    }

    public void clearCart() {
        items.clear();
    }

    public float getTotalPrice() {
        float totalPrice = 0;
        for (Menu item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }


}
