package com.food.app.controller;

import java.security.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.food.app.dao.DishRepository;
import com.food.app.dao.OrderRepository;
import com.food.app.dao.RestaurantRepository;
import com.food.app.dao.UserRepository;
import com.food.app.entities.Order;
import com.mongodb.internal.connection.Time;

@Controller
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    DishRepository dishRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired 
    OrderRepository orderRepository;

    @PostMapping("/createOrder/{userId}/{restaurantId}/{dishId}")
    public void createOrder(@PathVariable("userId") String userId,
                            @PathVariable("restaurantId") String restaurantId,
                            @PathVariable("dishId") String dishId){
        Order order = new Order();
        order.setId(userId+" "+restaurantId+" "+Time.nanoTime());
        order.setDish(dishRepository.findById(dishId).get());
        order.setRestaurant(restaurantRepository.findById(restaurantId).get());
        order.setUser(userRepository.findById(userId).get());
        System.out.println(order);
        orderRepository.save(order);
    }

    @GetMapping("/findAllOrders")
    public ResponseEntity<Object> findAllOrders(){
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }
    
}
