package it326.r4s.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * /Recipe book stores all the recipes of the system
 * /@author Shu Liao (fliao@ilstu.edu)
 * /@date 4/17/2022
 */
public class RecipeBook extends Entity {
    private Collection<Recipe> recipes;

    /**
     * default constructor
     */
    public RecipeBook() {
        this.recipes = new ArrayList<Recipe>();
    }

    /**
     * constructor with recipes
     * 
     * @param a collection of recipes
     */
    public RecipeBook(Collection<Recipe> recipes) {
        this.recipes = recipes;
    }

    /**
     * Add a recipe to the Recipe Book
     * 
     * @param toAdd the recipe object
     * @return trur if the recipe has been successfully added to the Recipe Book
     */
    public boolean addRecipe(Recipe toAdd) {
        for (Recipe recipe : recipes) {
            if (recipe.equals(toAdd)) {
                return false;
            }
        }
        recipes.add(toAdd);
        return true;
    }

    public void updateRecipe(Recipe newRecipe, Recipe oldRecipe){
        //TODO: implement this such that a recipe can be passed in which has new parameters
    }

    public Recipe getRecipe(Recipe theRecipe){
        return theRecipe; //TODO: Implement this method such that it returns the actual recipe from recipebook which is equivelant to the recipe passed in
    }

    /**
     * remove a recipe from the Recipe book
     * 
     * @param toRemove the recipe object
     * @return true if the recipe has been successfully remove from the Recipe Book
     */
    public boolean removeRecipe(Recipe toRemove) {
        for (Recipe recipe : recipes) {
            if (recipe.equals(toRemove)) {
                recipes.remove(toRemove);
                return true;
            }
        }
        return false;
    }

    public Collection<Recipe> getRecipes(){
        return this.recipes;
    }

    public void setRecipes(Collection<Recipe> recipes){
        this.recipes = recipes;
    }

    @Override
    public String toString() {
        String temp = "";
        for (Recipe recipe : recipes) {
            temp += recipe.toString() + "\n";
        }
        return "Recipes:\n" + temp;
    }
}
