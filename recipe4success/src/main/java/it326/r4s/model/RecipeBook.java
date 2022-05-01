package it326.r4s.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Recipe book stores all the recipes of the system
 * 
 * @author Shu Liao (fliao@ilstu.edu)
 * @date 4/17/2022
 */
public class RecipeBook extends Entity {
    // * Instance Variable *\\
    private Collection<Recipe> recipes;

    // * Constructors *\\
    /**
     * Creates a default RecipeBook object.
     */
    public RecipeBook() {
        this.recipes = new ArrayList<Recipe>();
    }

    /**
     * Creates a RecipeBook object with a specific collection of recipes.
     * 
     * @param recipes a collection of recipes for the RecipeBook.
     */
    public RecipeBook(Collection<Recipe> recipes) {
        this.recipes = recipes;
    }

    // * Methods *\\
    /**
     * Attemps to add a recipe to the RecipeBook.
     * 
     * @param toAdd the recipe object to be added.
     * @return true if the recipe has been successfully added to the RecipeBook,
     *         false otherwise.
     */
    public boolean addRecipe(Recipe toAdd) {
        for (Recipe recipe : recipes) {
            // TODO only add the recipe if there is no other recipe with the same name (i.e. ensure all recipe names in the collection are unique)
            if (recipe.equals(toAdd)) {
                return false;
            }
        }
        recipes.add(toAdd);
        return true;
    }

    /**
     * Attemps to remove a recipe from the RecipeBook.
     * 
     * @param toRemove the recipe object to be removed.
     * @return true if the recipe has been successfully remove from the RecipeBook,
     *         false otherwise.
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

    /**
     * An override for the .toString method of java.obj.
     * 
     * @return a string representation of the RecipeBook object.
     */
    @Override
    public String toString() {
        String temp = "";
        for (Recipe recipe : recipes) {
            temp += recipe.toString() + "\n";
        }
        return "Recipes:\n" + temp;
    }
}
