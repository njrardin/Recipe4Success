package it326.r4s;

import java.util.Hashtable;
public class FoodItemPool {

    private static Hashtable<String, FoodItem> foodItems;

    /**
     * Gets the food item from the pool with the appropriate name. 
     * If this food item does not exist, then it creates one, adds it to the pool, and returns it to the user.
     * @param name of the food item as a string
     * @return the food item from the pool with that name
     */
    public static FoodItem getFoodItem(String name){
        if(!foodItems.containsKey(name)){
            foodItems.put(name, new FoodItem(name));
        }
        return foodItems.get(name);
    }
}