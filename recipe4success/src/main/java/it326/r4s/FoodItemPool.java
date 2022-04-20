package it326.r4s;

import java.util.Hashtable;
public class FoodItemPool {

    private static Hashtable<String, FoodItem> foodItems;

    public static FoodItem getFoodItem(String name){
        if(!foodItems.containsKey(name)){
            foodItems.put(name, new FoodItem(name));
        }
        return foodItems.get(name);
    }
}