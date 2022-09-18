package com.food.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.food.app.entities.Order;

public interface OrderRepository extends MongoRepository<Order, String>{

    
}
