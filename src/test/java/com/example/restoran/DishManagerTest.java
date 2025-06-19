package com.example.restoran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DishManagerTest {

    private DishManager manager;

    @BeforeEach
    public void setUp() {
        manager = new DishManager();
        manager.addDish("Пельмени", "Тесто, мясо", 130.0);
        manager.addDish("Оливье", "Картошка, горошек, майонез", 100.0);
    }

    @Test
    public void testAddDishIncreasesListSize() {
        int initialSize = manager.getAllDishes().size();
        manager.addDish("Борщ", "Свекла, мясо", 120.0);

        assertEquals(initialSize + 1, manager.getAllDishes().size());
    }

    @Test
    public void testSearchDishFound() {
        List<Dish> result = manager.searchByName("Пельмени");

        assertEquals(1, result.size());
        assertEquals("Пельмени", result.get(0).getName());
    }

    @Test
    public void testSearchDishNotFound() {
        List<Dish> result = manager.searchByName("Шашлык");

        assertTrue(result.isEmpty());
    }

    @Test
    public void testSearchDishCaseInsensitive() {
        List<Dish> result = manager.searchByName("оЛИвЬе");

        assertEquals(1, result.size());
        assertEquals("Оливье", result.get(0).getName());
    }

    @Test
    public void testGetAllDishes() {
        List<Dish> all = manager.getAllDishes();

        assertEquals(2, all.size());
    }
}