package com.food.app.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.food.app.dao.UserRepository;
import com.food.app.entities.User;

@Controller
public class TempController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user){
        System.out.println(user);
        userRepository.save(user);
        return "done";
    }

    @GetMapping("/findUser")
    public String findUser(){
        List<User> list =new ArrayList<>();
        list = userRepository.findAll();
        StringBuilder sb = new StringBuilder();
        for(User user:list)
            sb.append(user.getId());
        System.out.println(sb);
        return sb.toString();

    }

}
