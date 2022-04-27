package it326.r4s;

/**
 * A basic FoodItem of the Recipes4Success application
 * 
 * @author PLEASE ADD YOUR NAME HERE
 * @date 4/26/2022
 */

public class FoodItem extends Entity {
    // * Instance Variables *\\
    private String name;
    private static int ID = 0;

    // *Constructors*\\
    /**
     * Creates a default FoodItem object.
     */
    public FoodItem() {
        super();
        this.name = "FoodItem_" + ++ID;
    }

    /**
     * Creates a FoodItem object with a specified name.
     * 
     * @param name the name of the FoodItem
     */
    public FoodItem(String name) {
        super();
        this.name = name;
        ID++;
    }

    // * Methods *\\
    /**
     * Gets the FoodItem's name.
     * 
     * @return the name of the FoodItem
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the FoodItem's ID.
     * 
     * @return the ID of the FoodItem.
     */
    public int getID() {
        return ID;
    }

    /**
     * An override for the .toString method of java.obj
     * 
     * @return a string representation of
     */
    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                "}";
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
        // If the object is compared with itself then return true
        if (obj == this) {
            return true;
        }
        // Check if the compared object is of correct type
        if (!(obj instanceof User)) {
            return false;
        }

        FoodItem otherFoodItem = (FoodItem) obj;
        return this.name.equals(otherFoodItem.getName()) && ID == otherFoodItem.getID();
    }
}
