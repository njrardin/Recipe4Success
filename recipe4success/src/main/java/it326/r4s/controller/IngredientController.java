package it326.r4s.controller;

import it326.r4s.model.Ingredient;
import it326.r4s.view.IngredientView;

/**
 * Controller for R4S IngredientController
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 5/01/22
 */
public class IngredientController {
    
    //*Instance Variables*\\
    private Ingredient ingredient;
    private IngredientView ingredientView;

    //*Constructor*\\
    /**
     * Constructor for R4S's IngredientController
     * @param ingredient - the controller's Ingredient object
     */
    public IngredientController(Ingredient ingredient){
        this.ingredient = ingredient;
        this.ingredientView = new IngredientView(this);
    }

    //*Methods*\\
    /**
     * Getter for the controller's Ingredient object
     * @return
     */
    public Ingredient getIngredient(){
        return this.ingredient;
    }

    /**
     * Facilitates the process of editing an ingredient
     * @return true if edit successful
     */
    public boolean editIngredient(){
        //edit fooditem
        FoodItemController fiControl = new FoodItemController(ingredient.getFoodItem());
        fiControl.editFoodItem();
        
        ingredient.setFoodItem(fiControl.getFoodItem());
        //edit unit
        ingredient.changeUnit(UnitController.getUnit());
        //edit quantity
        ingredient.setQuantity(ingredientView.editQuantity());

        return true;
    }
}
