package it326.r4s.view;

import it326.r4s.controller.IngredientController;
import it326.r4s.view.utilities.InputAccess;

/**
 * Controller for R4S IngredientView
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 5/01/22
 */
public class IngredientView {
    
    public IngredientController ingredientController;

    public IngredientView(IngredientController ingredientController){
        this.ingredientController = ingredientController;
    }

    public double editQuantity() {
        System.out.println("\nHow many " + ingredientController.getIngredient().getUnit() + "s of " + ingredientController.getIngredient().getFoodItem() + " are needed?");
        InputAccess ia = new InputAccess();

        do{
            try{
                return Double.parseDouble(ia.getInputLine());
            } catch (Exception e) {
                System.out.println("new quantity must be a number");
                continue;
            }
        } while (true);
    }
}
