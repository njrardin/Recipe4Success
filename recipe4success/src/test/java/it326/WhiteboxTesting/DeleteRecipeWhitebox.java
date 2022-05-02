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
        recipe1.setName("test recipe 1");
        ArrayList<Recipe> recipes = new ArrayList<Recipe>();
        recipes.add(recipe1);

        RecipeBook recipeBook = new RecipeBook(recipes);
        System.out.println("\nbasis path 1: before removal");
        System.out.println(recipeBook.toString());

        recipeBook.removeRecipe(recipe1);
        System.out.println("\nbasis path 1: after removal");
        System.out.println(recipeBook.toString());

        // basis path 2:
        recipeBook.addRecipe(recipe1);
        Recipe recipe2 = builder.build();
        recipe2.setName("test recipe 2");
        recipeBook.addRecipe(recipe2);
        System.out.println("\nbasis path 2: before removal");
        System.out.println(recipeBook.toString());

        recipeBook.removeRecipe(recipe2);
        System.out.println("\nbasis path 2: after removal");
        System.out.println(recipeBook.toString());

        // basis path 3:
        System.out.println("\nbasis path 3: before removal");
        System.out.println(recipeBook.toString());
        recipeBook.removeRecipe(recipe2);
        System.out.println("\nbasis path 3: after removal");
        System.out.println(recipeBook.toString());
        System.out.println();
    }
    
}
