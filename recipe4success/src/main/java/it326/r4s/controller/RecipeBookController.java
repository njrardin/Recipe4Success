package it326.r4s.controller;

import java.util.ArrayList;
import java.util.Collection;

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
    private RecipeBook recipeBook;
    private RecipeBookView recipeBookView;
    private UserController userController;

    //*Constructor*\\
    /**
     * Constructor for R4S's RecipeBookController
     * @param recipeBook - the controller's RecipeBook
     */
    public RecipeBookController(RecipeBook recipeBook, UserController userController){
        this.recipeBook = recipeBook;
        this.recipeBookView = new RecipeBookView(this);
        this.userController = userController;
    }

    //*Methods*\\
    /**
     * Getter for the controller's ReciepBook
     * @return the RecipeBook object
     */
    public RecipeBook getRecipeBook(){
        return this.recipeBook;
    }

    /**
     * Getter for the controller's RecipeBookview
     * @return the RecipeBookView object
     */
    public RecipeBookView getRecipeBookView(){
        return recipeBookView;
    }

    /**
     * Getter for the UserController which owns the RecipeBookController
     * @return the UserController
     */
    public UserController getUserController(){
        return this.userController;
    }


    /**
     * Gets a Collection of RecipeControllers associated with all recipes in the recipeBook
     * @return the Collection of RecipeControllers
     */
    public Collection<RecipeController> getRecipeControllers() {
        ArrayList<RecipeController> recipeControllers = new ArrayList<RecipeController>();

        for(Recipe recipe: recipeBook.getRecipes()){
            recipeControllers.add(new RecipeController(recipe, userController.getUser()));
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
                try{
                    selectRecipeController().openRecipe();
                } catch (RuntimeException re) { /* Do nothing */ }
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
        try{
            RecipeController selectedController = new RecipeController(selectRecipe(rsController.search()), userController.getUser());
            selectedController.openRecipe();
        }
        catch (IllegalArgumentException ie) { /*Do Nothing*/ }
        catch (RuntimeException e) { /*Do Nothing*/ }
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
     * selecting one of the recipes in the recipeBook
     */
    public RecipeController selectRecipeController() throws RuntimeException, IllegalArgumentException {
        try{
            return selectRecipeController(getRecipeControllers());
        }
        catch (IllegalArgumentException ie) { throw ie; }
        catch (RuntimeException e) { throw e; }
    }

    /**
     * Facilitates the process of the user
     * selecting one of the recipes from a collection of recipeControllers
     */
    public RecipeController selectRecipeController(Collection<RecipeController> recipeControllers) throws RuntimeException, IllegalArgumentException{
        RecipeController selectedRecipeController = null;
        try{
            selectedRecipeController = recipeBookView.getRecipeSelection(recipeControllers);
        } 
        catch (IllegalArgumentException ie) { throw ie; }
        catch (RuntimeException e) { throw e; }

        return selectedRecipeController;
    }

    /**
     * Facilitates the process of the user
     * selecting one of the recipes from a collection of recipeControllers
     * @throws IllegalArgumentException if a null collection is passed in
     */
    public Recipe selectRecipe(Collection<Recipe> recipes) throws RuntimeException, IllegalArgumentException{
        ArrayList<RecipeController> rControllers = new ArrayList<RecipeController>();
        for(Recipe recipe : recipes){
            rControllers.add(new RecipeController(recipe, userController.getUser()));
        }
        try{
            return selectRecipeController(rControllers).getRecipe();
        }
        catch (IllegalArgumentException ie) { throw ie; }
        catch (RuntimeException e) { throw e; }
    }

}
