package it326.r4s;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import it326.r4s.model.FoodItem;

public class FoodItemTest {
    private static FoodItem.Pool pool1 = null;
    private static FoodItem.Pool pool2 = null;
    private Collection<FoodItem> foodItems;

    @Before
    public void setUp() {
        pool1 = FoodItem.Pool.getInstance();
        pool1.getFoodItem("Apple");
        pool1.getFoodItem("Banana");
        pool1.getFoodItem("Cherry");

        pool2 = FoodItem.Pool.getInstance();
        pool2.getFoodItem("Apple");
        pool2.getFoodItem("Banana");
        pool2.getFoodItem("Cherry");
    }

    @Test
    public void testGetFoodItems() {
        foodItems = pool1.getFoodItems();
        ArrayList<FoodItem> actualFoodItems = new ArrayList<FoodItem>();
        for (FoodItem fi : foodItems) {
            actualFoodItems.add(fi);
        }
        Collection<FoodItem> foodItems2;
        foodItems2 = pool2.getFoodItems();
        ArrayList<FoodItem> expectedFoodItems = new ArrayList<FoodItem>();
        for (FoodItem fi : foodItems) {
            expectedFoodItems.add(fi);
        }
        assertEquals(expectedFoodItems, actualFoodItems);
    }

    @Test
    public void testRemoveFoodItem() {
        assertEquals(true, pool1.removeFoodItem("Banana"));
        assertEquals(false, pool1.removeFoodItem("Banana"));
        assertEquals(false, pool1.getFoodItems() == pool2.getFoodItems());
    }

    @Test
    public void testContains() {
        assertEquals(true, pool1.contains("Apple"));
        pool1.removeFoodItem("Apple");
        assertEquals(false, pool1.contains("Apple"));
        assertEquals(false, pool1.contains("Grape"));
    }

}
