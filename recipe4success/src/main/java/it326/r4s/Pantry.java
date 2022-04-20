package it326.r4s;

import java.util.Collection;

/**
 * The basic Pantry class of the Recipes4Success application.
 * Essentially just holds an ingredientList object as the pantry
 * @author Zach Plattner (zmplatt@ilstu.edu)
 * @date 4/6/22
 */
public class Pantry {
    private IngredientList ingredientList;

    public Pantry() {
        ingredientList = new IngredientList();
    }

    public IngredientList getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(IngredientList ingredientList) {
        this.ingredientList = ingredientList;
    }

    //method to remove a recipes ingredients from the pantry. returns false only if recipes ingredients DNE in pantry
    public boolean removeRecipeIngredients(Recipe recipe) {
        Collection<Ingredient> recipeIngredients = recipe.getIngredientList().getIngredients();
        return this.ingredientList.removeIngredients(recipeIngredients);
    }
}