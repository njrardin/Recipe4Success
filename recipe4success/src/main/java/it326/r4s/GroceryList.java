package it326.r4s;

/**
 * The basic GroceryList class of the Recipes4Success application.
 * Essentially just holds an ingredientList object as the groceryList
 * 
 * @author Zach Plattner (zmplatt@ilstu.edu)
 * @date 4/6/22
 */
public class GroceryList {
    // *Instance Variable*\\
    private IngredientList ingredientList;

    // *Constructor*\\
    /**
     * Creates a default GroceryList object
     */
    public GroceryList() {
        ingredientList = new IngredientList();
    }

    // *Methods*\\
    /**
     * Gets the GroceryList.
     * 
     * @return a list of ingredients in the grocery list.
     */
    public IngredientList getIngredientList() {
        return ingredientList;
    }

    /**
     * Sets the Grocerylist object.
     * 
     * @param ingredientList a new grocery list.
     */
    public void setIngredientList(IngredientList ingredientList) {
        this.ingredientList = ingredientList;
    }

    /**
     * An override for the .equals method of java.obj.
     * 
     * @param obj a GroceryList object.
     *            private IngredientList ingredientList;
     * @return True if two GroceryList objects are equal, false otherwise.
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

        GroceryList otheGroceryList = (GroceryList) obj;
        return this.ingredientList.equals(otheGroceryList.getIngredientList());
    }

    /**
     * An override for the .toString method of java.obj.
     * 
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return this.ingredientList.toString();
    }
}