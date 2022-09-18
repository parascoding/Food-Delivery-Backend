package com.food.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.food.app.dao.DishRepository;
import com.food.app.dao.OrderRepository;
import com.food.app.dao.RestaurantRepository;
import com.food.app.dao.UserRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {UserRepository.class, RestaurantRepository.class, DishRepository.class, OrderRepository.class})
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
