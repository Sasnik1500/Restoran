package com.example.restoran;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DishTest {

    @Test
    public void testDishCreation() {
        Dish dish = new Dish("Борщ", "Свекла, мясо, капуста", 120.0);

        assertEquals("Борщ", dish.getName());
        assertEquals("Свекла, мясо, капуста", dish.getComposition());
        assertEquals(120.0, dish.getPrice());
        assertTrue(dish.getId() > 0);  // ID должен быть положительным
    }

    @Test
    public void testMultipleDishIdsAreUnique() {
        Dish dish1 = new Dish("Плов", "Рис, мясо", 150.0);
        Dish dish2 = new Dish("Суп", "Картофель, морковь", 90.0);

        assertNotEquals(dish1.getId(), dish2.getId());  // У каждого блюда свой ID
    }
}