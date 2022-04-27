package it326.r4s;

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
     * An override for the .toString method of java.obj.
     * 
     * @return a string representation of the Pantry object.
     */
    @Override
    public String toString() {
        return this.ingredientList.toString();
    }

    // method to remove a recipes ingredients from the pantry. returns false only if
    // recipes ingredients DNE in pantry
    /**
     * Attempts to remove a recipe's ingredients from the Pantry.
     * 
     * @param recipe a recipe that contains the ingredients to be removed.
     * @return true when the ingredients of the recipe is successfully removed from
     *         the Pantry, false otherwise.
     */
    public boolean removeRecipeIngredients(Recipe recipe) {
        Collection<Ingredient> recipeIngredients = recipe.getIngredientList().getIngredients();
        return this.ingredientList.removeIngredients(recipeIngredients);
    }
}