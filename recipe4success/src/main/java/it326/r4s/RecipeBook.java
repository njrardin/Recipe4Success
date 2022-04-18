package it326.r4s;

import java.util.Collection;

/**
 * /Recipe book stores all the recipes of the system
 * /@author Shu Liao (fliao@ilstu.edu)
 * /@date 4/17/2022
 */
public class RecipeBook extends Entity {
    // recipe:<collection> recipe
    private Collection<Recipe> recipes;

    /**
     * default constructor
     */
    public RecipeBook() {
        this.recipes = new Collection<Recipe>();
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
     * @return a boolean indicator if the recipe has been successfully added to the
     *         Recipe Book
     */
    public boolean addRecipe(Recipe toAdd) {
        boolean flag = false;
        flag = recipes.add(toAdd);
        return flag;
    }

    /**
     * remove a recipe from the Recipe book
     * 
     * @param toRemove the recipe object
     * @return a boolean indicator if the recipe has been successfully remove from
     *         the Recipe Book
     */
    public boolean removeRecipe(Recipe toRemove) {
        boolean flag = false;
        for (Recipe recipe : recipes) {
            if (recipe.equals(toRemove)) {
                flag = recipes.remove(toRemove);
                break;
            }
        }
        return flag;
    }

}
