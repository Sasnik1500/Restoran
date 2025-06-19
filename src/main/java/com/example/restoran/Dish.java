package com.example.restoran;

public class Dish {
    private static int nextId = 1;

    private int id;
    private String name;
    private String composition;
    private double price;

    public Dish(String name, String composition, double price) {
        this.id = nextId++;
        this.name = name;
        this.composition = composition;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getComposition() {
        return composition;
    }

    public double getPrice() {
        return price;
    }
}
