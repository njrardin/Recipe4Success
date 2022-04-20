package it326.r4s;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FoodItemPoolTest {
    
    @Test
    public void testGetFoodItem(){
        assertEquals("egg", FoodItemPool.getFoodItem("egg").getName());
    }

    @Test
    public void testGetAllFoodItems(){
        assertNotNull(FoodItemPool.getAllFoodItems());
    }

    @Test
    public void testRemoveFoodItem(){
        FoodItemPool.getFoodItem("cheese");

        assertTrue(FoodItemPool.removeFoodItem("cheese"));
        assertFalse(FoodItemPool.removeFoodItem("cheese"));
    }
}
