package it326.r4s.view;

import it326.r4s.controller.IngredientListController;
import it326.r4s.model.Ingredient;

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
        for(Ingredient ingredient: igController.getIngredientList().getIngredients()){
            System.out.println(ingredient.toString());
        }
    }
}
