package it326.r4s.model;

import java.util.Collection;

/**
 * The basic GroceryList class of the Recipes4Success application.
 * Essentially just holds an ingredientList object as the groceryList
 * 
 * @author Zach Plattner (zmplatt@ilstu.edu)
 * @date 4/6/22
 */
public class GroceryList implements Portable {
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
     * Attempts to add an Ingredient to the GroceryList.
     * 
     * @param toAdd an Ingredient to be added to the GroceryList.
     * @return true if toAdd is already in ingredientList, false otherwise.
     */
    public boolean addIngredient(Ingredient toAdd) {
        return ingredientList.addIngredient(toAdd);
    }

    /**
     * Attempts to add an IngredientList of Ingredients to the GroceryList.
     * 
     * @param toAdd an IngredientList of Ingredients to be added to the GroceryList.
     * @return true if any Ingredient in toAdd is already in ingredientList, false
     *         otherwise.
     */
    public boolean addIngredients(IngredientList toAdd){
        return ingredientList.addIngredients(toAdd);
    }

    /**
     * Attempts to add an collection of Ingredients to the GroceryList.
     * 
     * @param toAdd a collection of Ingredients to be added to the GroceryList.
     * @return true if any Ingredient in toAdd is already in ingredientList, false
     *         otherwise.
     */
    public boolean addIngredients(Collection<Ingredient> toAdd){
        return ingredientList.addIngredients(toAdd);
    }

    /**
     * Attempts to remove an Ingredient from the IngredientList
     * 
     * @param ingredient an Ingredients to be removed from the GroceryList.
     * @return false if toRemove is not in Ingredients, true otherwise.
     */
    public boolean removeIngredient(Ingredient toRemove){
        return ingredientList.removeIngredient(toRemove);
    }

    /**
     * Attempts to remove a collection of Ingredients from the GroceryList.
     * 
     * @param toRemove a collection of Ingredients to be removed from the
     *                 GroceryList.
     * @return false if toRemove is not in the GroceryList, true otherwise.
     */
    public boolean removeIngredients(IngredientList toRemove) {
        return ingredientList.removeIngredients(toRemove);
    }

    /**
     * Attempts to remove a collection of Ingredients from the GroceryList.
     * 
     * @param toRemove a collection of Ingredients to be removed from the
     *                 GroceryList.
     * @return false if toRemove is not in the GroceryList, true otherwise.
     */
    public boolean removeIngredients(Collection<Ingredient> toRemove) {
        return ingredientList.removeIngredients(toRemove);
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

        GroceryList otherGroceryList = (GroceryList) obj;
        return this.ingredientList.equals(otherGroceryList.getIngredientList());
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