package it326.r4s;

import java.util.Collection;
import java.util.Hashtable;
/**
 * The Recipe object class for the Recipe4Success application
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/19/22
 */
public class FoodItemPool {

    private static Hashtable<String, FoodItem> foodItems;

    /**
     * Gets the food item from the pool with the appropriate name. 
     * If this food item does not exist, then it creates one, adds it to the pool, and returns it to the user.
     * @param name of the food item as a string
     * @return the food item from the pool with that name
     */
    public static FoodItem getFoodItem(String name){
        addFoodItem(name);
        return foodItems.get(name);
    }

    public static  void addFoodItem(String name){
        if(!foodItems.containsKey(name)){
            foodItems.put(name, new FoodItem(name));
        }
    }

    public static Collection<FoodItem> getAllFoodItems(){
        return foodItems.values();
    }
}