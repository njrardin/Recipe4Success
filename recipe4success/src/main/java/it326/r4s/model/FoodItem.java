package it326.r4s.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * The FoodItem class of the Recipes4Success application
 * 
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/2022
 */
public class FoodItem extends Entity {
    // * Instance Variables *\\
    private String name;

    // *Constructors*\\
    /**
     * Creates a default FoodItem object.
     */
    private FoodItem() {}

    /**
     * Creates a FoodItem object with a specified name.
     * 
     * @param name the name of the FoodItem
     */
    private FoodItem(String name){
        this.name = name;
    }

    // * Methods *\\
    /**
     * Gets the FoodItem's name.
     * 
     * @return the name of the FoodItem
     */
    public String getName(){
        return this.name;
    }

    /**
     * An override for the .toString method of java.obj
     * 
     * @return a string representation of
     */
    @Override
    public String toString() {
        return this.name;
    }
    
    /**
     * An override for the .equals method of java.obj.
     * private String name;
     * private static int ID;
     * 
     * @return a bool indicating if the two FoodItems are equal.
     */
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
    public static class Pool implements Portable {
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

        public boolean contains(String name) {
            FoodItem fi = new FoodItem(name);
            return foodItems.contains(fi);
        }

        private FoodItem addFoodItem(String name) {
            FoodItem fi = new FoodItem(name);
            foodItems.add(fi);
            return fi;
        }
    }
}
