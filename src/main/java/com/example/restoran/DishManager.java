package com.example.restoran;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DishManager {
    private List<Dish> dishes = new ArrayList<>();

    public void addDish(String name, String composition, double price) {
        Dish dish = new Dish(name, composition, price);
        dishes.add(dish);
    }

    public List<Dish> getAllDishes() {
        return dishes;
    }

    public List<Dish> searchByName(String name) {
        return dishes.stream()
                .filter(d -> d.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}


