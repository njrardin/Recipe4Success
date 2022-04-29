package it326.r4s.controller;

import java.util.ArrayList;

import it326.r4s.model.Pantry;
import it326.r4s.model.Recipe;
import it326.r4s.model.User;
import it326.r4s.view.PantryView;
import it326.r4s.view.RecipeBookView;
/**
 * Controller for R4S Pantry
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class PantryController {

    private Pantry pantry;
    private PantryView pantryView;

    public PantryController(Pantry pantry){
        this.pantry = pantry;
        this.pantryView = new PantryView(this);
    }

    //*Methods*\\
    public IngredientListController getIngredientListController() {
        return new IngredientListController(pantry.getIngredientList());
    }

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
                    removeRecipeIngredients();
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
        }    }
        


    /**
     * Facilitats the process of the user
     * adding an ingredient to the pantry
     */
    public void addIngredient() {
        pantry.addIngredientList(pantryView.getNewIngredientsFromUser());
    }
    
    /**
     * Facilitats the process of the user
     * removing an ingredient from the pantry
     */
    public void removeIngredient() {
        pantry.removeIngredient(pantryView.getIngredientRemovalFromUser());
    }

    private void removeRecipeIngredients() {
        User theUser = UserController.getUserController().getGlobalUser();
        
        ArrayList<RecipeController> recipeControllers = new ArrayList<RecipeController>();
        for(Recipe recipe: theUser.getRecipeBook().getRecipes()){
            recipeControllers.add(new RecipeController(recipe));
        }
        try{
            RecipeController selectedRecipeController = RecipeBookView.getRecipeSelection(recipeControllers);
            Recipe selectedRecipe = selectedRecipeController.getRecipe();
            pantry.removeRecipeIngredients(selectedRecipe);
        } catch (RuntimeException e) { 
            System.out.println("Oops, looks like there was an error with removing the ingredients.");
         }
    }

    private void listMakableRecipes() {

    }
    
}
