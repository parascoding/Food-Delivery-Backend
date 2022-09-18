package com.food.app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Dish")
public class Dish {
    private String name;
    private double price;
    @Id
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    Dish(String id){
        this.id = id;
    }

    @Override
    public String toString(){
        return "Dish "+" [ name: "+name+", price: "+price+" ]";
    }
}
