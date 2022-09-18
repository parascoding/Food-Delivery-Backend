package com.food.app.entities;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document("Restaurant")
public class Restaurant {
    private String name;
    private String address;
    @Id
    private String id;

    @DocumentReference
    private List<Dish> dishes;

    public List<Dish> getDishes() {
        return this.dishes;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    Restaurant(String id){
        this.id = id;
        if(dishes==null||dishes.size()==0)
            this.dishes = new LinkedList<>();
    }
    public void addDish(Dish dish){
        this.dishes.add(dish);
    }
    @Override
    public String toString(){
        return "Restaurant "+" [ name: "+name+", address: "+address+" ]";
    }
}
