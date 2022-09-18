package com.food.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.food.app.entities.Restaurant;

public interface RestaurantRepository extends MongoRepository<Restaurant, String>{
    
}
