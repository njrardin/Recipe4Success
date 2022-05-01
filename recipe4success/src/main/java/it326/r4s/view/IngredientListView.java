package it326.r4s.view;

import it326.r4s.controller.IngredientListController;
import it326.r4s.model.Ingredient;
import it326.r4s.view.utilities.InputAccess;

/**
 * View for R4S Recipe
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/27/22
 */
public class IngredientListView {   
    
    //*Instance Variables\\
    private IngredientListController igController;

    //*Constructor*\\
    /**
     * Constructor for R4S's IngredientListView
     * @param igController - the IngredientListView's controller
     */
    public IngredientListView(IngredientListController igController){
        this.igController = igController;
    }

    /**
     * Displays the ingredients in the list
     */
    public void displayIngredients(){
        int i = 1;
        for(Ingredient ingredient: igController.getIngredientList().getIngredients()){
            System.out.println(i + ") " + ingredient.toString());
            i++;
        }
    }

    /**
     * Allows the user to select an ingredient in the ingredientlist
     * @return the ingredient
     */
    public Ingredient selectIngredient(){
        System.out.println();
        displayIngredients();

        InputAccess input = new InputAccess();
        int selection = -1;
        do{
            System.out.print("Please select an option by entering the corresponding number: ");
            try{
                selection = Integer.parseInt(input.getInputLine());
            } catch (Exception e) {
                System.out.println("Invalid input, selection must be a number:");
                continue;
            }
        } while( !(0 < selection && selection <= igController.getIngredientList().getIngredients().size()));

        return igController.getIngredientList().getIngredients().get(selection - 1);
    }
}
