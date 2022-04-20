package it326.r4s;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FoodItemPoolTest {
    
    @Test
    public void testGetFoodItem(){
        assertEquals("egg", FoodItemPool.getFoodItem("egg").getName());
    }
}
