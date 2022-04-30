package it326.r4s.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import it326.r4s.controller.RecipeController.RecipeBuilderController;
import it326.r4s.model.Recipe;
import it326.r4s.model.RecipeBook;
import it326.r4s.view.RecipeBookView;

/**
 * Controller for R4S RecipeBook
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class RecipeBookController {
    
    //*Instance Variables*\\
    public RecipeBook recipeBook;
    public RecipeBookView recipeBookView;

    //*Constructor*\\
    /**
     * Constructor for R4S's RecipeBookController
     * @param recipeBook - the controller's RecipeBook
     */
    public RecipeBookController(RecipeBook recipeBook){
        this.recipeBook = recipeBook;
        this.recipeBookView = new RecipeBookView(this);
    }

    //*Methods*\\
    /**
     * Getter for the controller's RecipeBookview
     * @return the RecipeBookView object
     */
    public RecipeBookView getRecipeBookView(){
        return recipeBookView;
    }

    /**
     * Getter for the controller's ReciepBook
     * @return the RecipeBook object
     */
    public RecipeBook getRecipeBook(){
        return this.recipeBook;
    }

    /**
     * Gets an ArrayList of RecipeControllers associated with all recipes in the recipeBook
     * @return the ArrayList of RecipeControllers
     */
    public ArrayList<RecipeController> getRecipeControllers(){
        ArrayList<RecipeController> recipeControllers = new ArrayList<RecipeController>();
        for(Recipe recipe: recipeBook.getRecipes()){
            recipeControllers.add(new RecipeController(recipe));
        }
        return recipeControllers;
    }

    /**
     * Launches the recipeBookView to get a user option selection
     * and then takes the appropriate action
     */
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
            recipeBookView.displayHeader();
            recipeBookView.displayRecipeBook();
        }
    }
    
    /**
     * Facilitates the process of the user 
     * searching through the recipes in the recipebook
     */
    public void searchRecipes() {
        RecipeSearchController rsController = new RecipeSearchController(recipeBook.getRecipes());
        String searchQuery = rsController.getRecipeSearchView().getSearchQuery();
        ArrayList<Recipe> returnRecipes = rsController.searchFor(searchQuery);
        
        selectRecipe(returnRecipes);
    }

    /**
     * Facilitates the process of the user
     * importing a recipe into the application
     */
    public void importRecipe() {
        //TODO - req 8
    }

    /**
     * Facilitates the process of the user
     * exporting a recipe out of the application
     */
    public void exportRecipe() {
        //TODO - req 7
        //note for alex: use the selectRecipe method first then 
        //export the selected recipe
    }

    /**
     * Facilitates the process of the user
     * creating a new recipe for the recipeBook
     */
    public void createRecipe(){
        RecipeBuilderController rBuildController = new RecipeBuilderController();

        Recipe newRecipe = rBuildController.buildUserRecipe();

        recipeBook.addRecipe(newRecipe);
    }

    /**
     * Facilitates the process of the user
     * selecting one of the recipes in the recipeNook
     */
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
