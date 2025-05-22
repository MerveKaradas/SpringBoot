package com.doyur.demo.repository.abstracts;

import com.doyur.demo.model.Restaurant;
import com.doyur.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
    Optional<Restaurant> findByRestaurantName(String restaurantName);
}
