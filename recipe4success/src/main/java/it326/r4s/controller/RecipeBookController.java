package it326.r4s.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import it326.r4s.controller.RecipeController.RecipeBuilderController;
import it326.r4s.model.Recipe;
import it326.r4s.model.RecipeBook;
import it326.r4s.model.Recipe.RecipeBuilder;
import it326.r4s.view.RecipeBookView;
import it326.r4s.view.RecipeView;
import it326.r4s.view.ViewUtilities;
/**
 * Controller for R4S RecipeBook
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class RecipeBookController {
    
    public RecipeBook recipeBook;
    public RecipeBookView recipeBookView;

    public RecipeBookController(RecipeBook recipeBook){
        this.recipeBook = recipeBook;
        this.recipeBookView = new RecipeBookView(this);
    }

    public RecipeBookView getRecipeBookView(){
        return recipeBookView;
    }

    public RecipeBook getRecipeBook(){
        return this.recipeBook;
    }

    public ArrayList<RecipeController> getRecipeControllers(){
        ArrayList<RecipeController> recipeControllers = new ArrayList<RecipeController>();
        for(Recipe recipe: recipeBook.getRecipes()){
            recipeControllers.add(new RecipeController(recipe));
        }
        return recipeControllers;
    }

    public void openRecipeBook(){
        recipeBookView.displayHeader();
        recipeBookView.displayRecipeBook();
        int option;
        while (true) {
            option = recipeBookView.getMenuOptionSelection();
            switch (option) {
                case 1:
                    searchRecipes();
                    break;
                case 2:
                    importRecipe();
                    break;
                case 3:
                    exportRecipe();
                    break;
                case 4:
                    createRecipe();
                    break;
                case 5:
                    selectRecipe(recipeBook.getRecipes());
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid input, please try again\n");
            }
        }
    }
    
    public void searchRecipes() {
        RecipeSearchController rsController = new RecipeSearchController(recipeBook.getRecipes());
        String searchQuery = rsController.getRecipeSearchView().getSearchQuery();
        ArrayList<Recipe> returnRecipes = rsController.searchFor(searchQuery);
        
        selectRecipe(returnRecipes);
    }

    public void importRecipe() {
        //TODO - req 8
    }

    public void exportRecipe() {
        //TODO - req 7
    }

    public void createRecipe(){
        RecipeBuilderController rBuildController = new RecipeBuilderController();

        Recipe newRecipe = rBuildController.buildUserRecipe();

        recipeBook.addRecipe(newRecipe);
    }

    public void selectRecipe(Collection<Recipe> recipes){
        ArrayList<RecipeController> recipeControllers = new ArrayList<RecipeController>();
        for(Recipe recipe: recipes){
            recipeControllers.add(new RecipeController(recipe));
        }
        try{
            RecipeController selectedRecipeController = recipeBookView.getRecipeSelection(recipeControllers);
            selectedRecipeController.openRecipe();
        } catch (RuntimeException e) { /*do nothing*/ }
    }
}
