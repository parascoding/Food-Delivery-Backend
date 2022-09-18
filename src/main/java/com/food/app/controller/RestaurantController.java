package com.food.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.food.app.dao.RestaurantRepository;
import com.food.app.entities.Restaurant;

@Controller
@RequestMapping("/api/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantRepository restaurantRepository;

    @PostMapping("/addRestaurant")
    public List<String> addRestaurant(@ModelAttribute Restaurant restaurant){
        restaurantRepository.save(restaurant);
        return new ArrayList<>(List.of("Done"));
    }

    @GetMapping("/findAllRestaurant")
    public ResponseEntity<Object> findAllRestaurant(){
        List<Restaurant> restaurants = restaurantRepository.findAll();
        for(Restaurant restaurant : restaurants){
            System.out.println(restaurant.getDishes().size());
        }
        return new ResponseEntity<>(restaurantRepository.findAll(), HttpStatus.OK);
    }
}
