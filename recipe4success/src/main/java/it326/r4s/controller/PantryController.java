package it326.r4s.controller;

import java.util.ArrayList;

import it326.r4s.model.Pantry;
import it326.r4s.model.Recipe;
import it326.r4s.view.PantryView;
/**
 * Controller for R4S Pantry
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class PantryController {

    private Pantry pantry;
    private PantryView pantryView;
    private UserController userController;

    /**
     * Constructor for R4S's PantryController
     * @param pantry
     * @param userController - the UserController which controls this Pantry
     */
    public PantryController(Pantry pantry, UserController userController){
        this.pantry = pantry;
        this.pantryView = new PantryView(this);
        this.userController = userController;
    }

    //*Methods*\\
    /**
     * Getter for the PantryController's pantry
     * @return the pantry
     */
    public Pantry getPantry(){
        return this.pantry;
    }

    /**
     * Getter for the PantryController's PantryView
     * @return the PantryView
     */
    public PantryView getPantryView(){
        return this.pantryView;
    }

    /**
     * Getter for the UserController which owns the MealPlannerController
     * @return the UserController
     */
    public UserController getUserController(){
        return this.userController;
    }

    /**
     * Getter for the IngredientListController which controls the Pantry's IngredientList
     * @return the IngredientListController
     */
    public IngredientListController getIngredientListController() {
        return new IngredientListController(pantry.getIngredientList());
    }

    /**
     * Launches the Pantry's main menu 
     * to get a user option selection
     * and then takes the appropriate action
     */
    public void openPantry(){
        pantryView.displayHeader();
        pantryView.displayPantry();
        int option;
        while (true) {
            option = pantryView.getMenuOptionSelection();
            switch (option) {
                case 1:
                    addIngredient();
                    break;
                case 2:
                    removeIngredient();
                    break;
                case 3:
                    removeRecipeControllerIngredients(userController.getRecipeBookController().selectRecipeController());
                    break;
                case 4:
                    listMakableRecipes();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid input, please try again\n");
            }
            pantryView.displayHeader();
            pantryView.displayPantry();
        }    
    }
        


    /**
     * Facilitats the process of the user
     * adding an ingredient to the pantry
     */
    public void addIngredient() {
        pantry.addIngredients(pantryView.getNewIngredientsFromUser());
    }
    
    /**
     * Facilitats the process of the user
     * removing an ingredient from the pantry
     */
    public void removeIngredient() {
        pantry.removeIngredient(pantryView.getIngredientRemovalFromUser());
    }

    private void removeRecipeControllerIngredients(RecipeController recipeController) {        
        try{
            pantry.removeRecipeIngredients(recipeController.getRecipe());
        } catch (RuntimeException e) { 
            System.out.println("Oops, looks like there was an error with removing the ingredients.");
        }
    }

    private void listMakableRecipes() {        
        ArrayList<RecipeController> recipeControllers = new ArrayList<RecipeController>();
        for(Recipe recipe: userController.getUser().getMakeableRecipes()){
            recipeControllers.add(new RecipeController(recipe, userController.getUser()));
        }
        //TODO: implement
    }
    
}
