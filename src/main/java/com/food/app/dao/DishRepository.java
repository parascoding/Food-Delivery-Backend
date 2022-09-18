package com.food.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.food.app.entities.Dish;

public interface DishRepository extends MongoRepository<Dish, String>{
    
}
