package com.food.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.food.app.entities.User;
@Repository
public interface UserRepository extends MongoRepository<User, String>{
    
}
