package it326.r4s.model;

import java.util.HashSet;
public class FoodItemPool {

    private static HashSet<FoodItem> foodItems;

    public static boolean addFoodItem(FoodItem foodItem){
        for(FoodItem poolItem: foodItems){
            if(foodItem.equals(poolItem))
                return false;
        }
        return foodItems.add(foodItem);
    }

    public static boolean removeFoodItem(FoodItem foodItem){
        return foodItems.remove(foodItem);
    }

    public static boolean hasFoodItem(FoodItem foodItem){
        return foodItems.contains(foodItem);
    }

}