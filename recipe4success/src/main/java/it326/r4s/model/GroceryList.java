package it326.r4s.model;

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
     * Adds the new ingredient list to the grocery list
     * @param toAdd - the ingredientlist to add
     */
    public void addIngredientList(IngredientList toAdd){
        for(Ingredient ingredient: toAdd.getIngredients()){
            ingredientList.addIngredient(ingredient);
        }
    }

    public boolean removeIngredient(Ingredient ingredient){
        return ingredientList.removeIngredient(ingredient);
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
        // Check if the compared object is of correct type
        if (!(obj instanceof GroceryList) || obj == null) {
            return false;
        }
        // If the object is compared with itself then return true 
        if (obj == this) {
            return true;
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