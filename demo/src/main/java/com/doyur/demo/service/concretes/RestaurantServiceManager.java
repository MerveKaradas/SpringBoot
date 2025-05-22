package com.doyur.demo.service.concretes;

import com.doyur.demo.model.Restaurant;
import com.doyur.demo.model.User;
import com.doyur.demo.repository.abstracts.RestaurantRepository;
import com.doyur.demo.service.abstracts.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceManager implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceManager(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant findRestaurantById(int id) {
        return restaurantRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findByRestaurantName(restaurant.getRestaurantName());
        if (restaurantOptional.isPresent()) {
            throw new IllegalArgumentException("Restaurant already exists");
        }
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(int id, Restaurant restaurant) {
        Restaurant restaurantToUpdate = restaurantRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));

        restaurantToUpdate.setRestaurantName(restaurant.getRestaurantName());
        restaurantToUpdate.setRestaurantAddress(restaurant.getRestaurantAddress());
        restaurantToUpdate.setComment(restaurant.getComment());
        restaurantToUpdate.setOwner(restaurant.getOwner());
        restaurantToUpdate.setRating(restaurant.getRating());
        restaurantToUpdate.setMinOrderAmount(restaurant.getMinOrderAmount());

        return restaurantRepository.save(restaurantToUpdate);



    }
    private boolean resaurantExists(int id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        return restaurantOptional.isPresent();
    }
    @Override
    public void deleteRestaurant(int id) {
        if (!resaurantExists(id)) { //eğer restoran bulunamazsa hata mesajı döndürür
            throw new IllegalArgumentException("Restaurant not found");
        }else
        {
            restaurantRepository.deleteById(id); //başarılı bir silme işlemi durumunda HTTP 204 NO CONTENT yanıtını döndürür.
        }
    }


}
