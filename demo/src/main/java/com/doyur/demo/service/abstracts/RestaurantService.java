package com.doyur.demo.service.abstracts;

import com.doyur.demo.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAllRestaurants();

    Restaurant findRestaurantById(int id);

    Restaurant saveRestaurant(Restaurant restaurant);

    Restaurant updateRestaurant(int id, Restaurant restaurant);

    void deleteRestaurant(int id);
}
