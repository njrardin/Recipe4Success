package it326.WhiteboxTesting;
import it326.r4s.model.RecipeBook;
import it326.r4s.model.Recipe.RecipeBuilder;
import it326.r4s.model.Recipe;
import java.util.ArrayList;

/**
 * 
 * 
 */
public class DeleteRecipeWhitebox {

    public static void main(String[] args) {
        RecipeBuilder builder = new RecipeBuilder("test recipe 1");

        // basis path 1:
        Recipe recipe1 = builder.build();
        ArrayList<Recipe> recipes = new ArrayList<Recipe>();

        RecipeBook recipeBook = new RecipeBook(recipes);

        recipeBook.removeRecipe(recipe1);
    }
    
}
