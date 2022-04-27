package it326.r4s.model;

/**
 * The Recipe object class for the Recipe4Success application
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/27/22
 */
public class FoodItem extends Entity {
    private String name;

    public FoodItem(String name){
        this.name = name;
        FoodItemPool.addFoodItem(this);
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
}
