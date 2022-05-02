package it326.r4s.model;

import java.util.Collection;

/**
 * The basic Pantry class of the Recipes4Success application.
 * Essentially just holds an ingredientList object as the pantry
 * 
 * @author Zach Plattner (zmplatt@ilstu.edu)
 * @date 4/6/22
 */
public class Pantry {
    // *Instance Variable*\\
    private IngredientList ingredientList;

    // *Constructor*\\
    /**
     * Creates a default Pantry object.
     */
    public Pantry() {
        ingredientList = new IngredientList();
    }

    // *Methods*\\
    /**
     * Gets the Pantry's ingredient list.
     * 
     * @return the ingredient list of the pantry.
     */
    public IngredientList getIngredientList() {
        return ingredientList;
    }

    /**
     * Sets the Pantry's ingredient list.
     * 
     * @param ingredientList the new ingredient list of the Pantry.
     */
    public void setIngredientList(IngredientList ingredientList) {
        this.ingredientList = ingredientList;
    }

    /**
     * Attempts to add an Ingredient to the Pantry.
     * 
     * @param toAdd an Ingredient to be added to the Pantry.
     * @return true if toAdd is already in ingredientList, false otherwise.
     */
    public boolean addIngredient(Ingredient toAdd) {
        return ingredientList.addIngredient(toAdd);
    }

    /**
     * Attempts to add an IngredientList of Ingredients to the Pantry.
     * 
     * @param toAdd an IngredientList of Ingredients to be added to the Pantry.
     * @return true if any Ingredient in toAdd is already in ingredientList, false
     *         otherwise.
     */
    public boolean addIngredients(IngredientList toAdd){
        return ingredientList.addIngredients(toAdd);
    }

    /**
     * Attempts to add an collection of Ingredients to the Pantry.
     * 
     * @param toAdd a collection of Ingredients to be added to the Pantry.
     * @return true if any Ingredient in toAdd is already in ingredientList, false
     *         otherwise.
     */
    public boolean addIngredients(Collection<Ingredient> toAdd){
        return ingredientList.addIngredients(toAdd);
    }

    /**
     * Attempts to remove an Ingredient from the IngredientList
     * 
     * @param ingredient an Ingredients to be removed from the Pantry.
     * @return false if toRemove is not in Ingredients, true otherwise.
     */
    public boolean removeIngredient(Ingredient toRemove){
        return ingredientList.removeIngredient(toRemove);
    }

    /**
     * Attempts to remove a collection of Ingredients from the Pantry.
     * 
     * @param toRemove a collection of Ingredients to be removed from the
     *                 Pantry.
     * @return false if toRemove is not in the Pantry, true otherwise.
     */
    public boolean removeIngredients(IngredientList toRemove) {
        return ingredientList.removeIngredients(toRemove);
    }

    /**
     * Attempts to remove a collection of Ingredients from the Pantry.
     * 
     * @param toRemove a collection of Ingredients to be removed from the
     *                 Pantry.
     * @return false if toRemove is not in the Pantry, true otherwise.
     */
    public boolean removeIngredients(Collection<Ingredient> toRemove) {
        return ingredientList.removeIngredients(toRemove);
    }

    /**
     * Attempts to remove a recipe's ingredients from the Pantry.
     * 
     * @param recipe a recipe that contains the ingredients to be removed.
     * @return true when the ingredients of the recipe is successfully removed from
     *         the Pantry, false otherwise.
     */
    public boolean removeRecipeIngredients(Recipe recipe) {
        return this.ingredientList.removeIngredients(recipe.getIngredientList().getIngredients());
    }

    /**
     * An override for the .toString method of java.obj.
     * 
     * @return a string representation of the Pantry object.
     */
    @Override
    public String toString() {
        return this.ingredientList.toString();
    }


}