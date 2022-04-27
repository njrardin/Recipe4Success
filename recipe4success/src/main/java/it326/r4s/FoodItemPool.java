package it326.r4s;

/**
 * A basic FoodItemPool of the Recipes4Success application
 * @author 
 * @date 4/26/2022
 */
import java.util.HashSet;

public class FoodItemPool {
    // *Instance Variable*\\
    private static HashSet<FoodItem> foodItems;

    // *Methods*\\
    /**
     * Attempts to add a FoodItem object to the collection.
     * 
     * @param foodItem the FoodItem to be added.
     * @return true if the FoodItem was added, false otherwise.
     */
    public static boolean addFoodItem(FoodItem foodItem) {
        return foodItems.add(foodItem);
    }

    /**
     * Attempts to remove a FoodItem from the collection.
     * 
     * @param foodItem the FoodItem to be removed.
     * @return true if the FoodItem was removed, false otherwise.
     */
    public static boolean removeFoodItem(FoodItem foodItem) {
        return foodItems.remove(foodItem);
    }

    public static boolean hasFoodItem(FoodItem foodItem) {
        return foodItems.contains(foodItem);
    }

}