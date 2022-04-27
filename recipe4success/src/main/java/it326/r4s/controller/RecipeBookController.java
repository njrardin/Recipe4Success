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
public class RecipeBookController implements CLI_Controller {
    
    public RecipeBook recipeBook;
    public RecipeBookView recipeBookView;

    public RecipeBookController(RecipeBook recipeBook){
        this.recipeBook = recipeBook;
        this.recipeBookView = new RecipeBookView(this);
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

    public void executeView(){
        recipeBookView.execute();
    }
    
    public void exportRecipe() {
        //TODO - req 7
    }
    
    public void searchRecipes() {
        RecipeSearchController rsController = new RecipeSearchController(recipeBook.getRecipes());
        String searchQuery = recipeBookView.getSearchQuery();
        ArrayList<Recipe> returnRecipes = rsController.searchFor(searchQuery);
        
        selectRecipe(returnRecipes);
    }
    
    public void filterRecipeByCategory() {
        RecipeSearchController rsController = new RecipeSearchController(recipeBook.getRecipes());
        String searchQuery = recipeBookView.getSearchQuery();
        ArrayList<Recipe> returnRecipes = rsController.searchFor(searchQuery);
        
        selectRecipe(returnRecipes);
    }

    public void importRecipe() {
        //TODO - req 8
    }


    public void selectRecipe(Collection<Recipe> recipes){
        ArrayList<RecipeController> recipeControllers = new ArrayList<RecipeController>();
        for(Recipe recipe: recipes){
            recipeControllers.add(new RecipeController(recipe));
        }
        try{
            RecipeController selectedRecipe = recipeBookView.displayAndSelect(recipeControllers);
            selectedRecipe.executeView();
        } catch (RuntimeException e) { /*do nothing*/ }
    }

    public void viewRecipes(){
        RecipeView recipeView;
        int i = 1;
        for(Recipe recipe: recipeBook.getRecipes()){
            recipeView =  new RecipeView(new RecipeController(recipe));
            System.out.println(i);
            recipeView.displayOneline();
            i++;
        }
    }

    public void createRecipe(){
        RecipeBuilderController rBuildController = new RecipeBuilderController();

        Recipe newRecipe = rBuildController.buildUserRecipe();

        recipeBook.addRecipe(newRecipe);
    }
}
