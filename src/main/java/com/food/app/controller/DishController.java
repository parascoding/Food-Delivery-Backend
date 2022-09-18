package com.food.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.food.app.dao.DishRepository;
import com.food.app.dao.RestaurantRepository;
import com.food.app.entities.Dish;
import com.food.app.entities.Restaurant;

@Controller
@RequestMapping("/api/dish")
public class DishController {
    
    @Autowired
    DishRepository dishRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @PostMapping("/addDish/{restaurantId}")
    public void addDish(@PathVariable("restaurantId") String restaurantId, 
                                    @ModelAttribute Dish dish){
        System.out.println(restaurantId+" "+dish);
        dishRepository.save(dish);
        Optional<Restaurant> optionalRestaunrant = restaurantRepository.findById(restaurantId);
        Restaurant restaurant = optionalRestaunrant.get();

        restaurant.addDish(dish);
        
        restaurantRepository.save(restaurant);


    }

    @PostMapping("/addDishToAll")
    public void addDishToAll(@ModelAttribute Dish dish){
        List<Restaurant> restaurants = restaurantRepository.findAll();
        for(Restaurant restaurant : restaurants){
            restaurant.addDish(dish);
            restaurantRepository.save(restaurant);
        }
        dishRepository.save(dish);
    }

    @GetMapping("/findAllDishes")
    public ResponseEntity<Object> findAllDishes(){
        return new ResponseEntity<>(dishRepository.findAll(), HttpStatus.OK);
    }

    

}
