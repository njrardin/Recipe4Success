package it326.r4s.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * The Recipe object class for the Recipe4Success application
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/27/22
 */
public class FoodItem extends Entity {
    private String name;

    private FoodItem() {}

    private FoodItem(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            "}";
    }
    
    @Override
    public boolean equals(Object obj) {
        // Check if the compared object is of correct type
        if (!(obj instanceof FoodItem) || obj == null) {
            return false;
        }
        // If the object is compared with itself then return true 
        if (obj == this) {
            return true;
        }

        FoodItem otherFoodItem = (FoodItem) obj;
        return this.name.equals(otherFoodItem.getName());
    }

    /**
     * A singleton pool of available food items.
     * 
     * @author Alex Smith (alsmi14@ilstu.edu)
     * @date 4/27/22
     */
    public static class Pool {
        private static Pool pool = null;
        private Collection<FoodItem> foodItems;

        private Pool() {
            foodItems = new ArrayList<>();
        }

        public static Pool getInstance() {
            if (pool == null) {
                pool = new Pool();
            }

            return pool;
        }

        public FoodItem getFoodItem(String name) {
            for (FoodItem fi : foodItems) {
                if (fi.getName().equals(name)) {
                    return fi;
                }
            }

            return addFoodItem(name);
        }

        public boolean removeFoodItem(String name) {
            FoodItem fi = new FoodItem(name);
            return foodItems.remove(fi);
        }

        public Collection<FoodItem> getFoodItems() {
            return Collections.unmodifiableCollection(foodItems);
        }

        private FoodItem addFoodItem(String name) {
            FoodItem fi = new FoodItem(name);
            foodItems.add(fi);
            return fi;
        }
    }
}
