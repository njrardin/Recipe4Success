package it326.r4s.controller;

import it326.r4s.model.IngredientList;
import it326.r4s.view.IngredientListView;

/**
 * View for R4S Recipe
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/27/22
 */
public class IngredientListController {

    //*Instance Variables*\\
    private IngredientList ingredientList;
    private IngredientListView igView;

    //*Constructor*\\
    /**
     * Constructor for R4S's IngredientListController
     * @param ingredientList
     */
    public IngredientListController(IngredientList ingredientList){
        this.ingredientList = ingredientList;
        this.igView = new IngredientListView(this);
    }

    //*Methods*\\
    /**
     * Getter for the controller's IngredientListView
     * @return the IngredientListView object
     */
    public IngredientListView getIngredientListView(){
        return this.igView;
    }

    /**
     * Getter for the controller's IngredientList
     * @return the IngredientList object
     */
    public IngredientList getIngredientList(){
        return this.ingredientList;
    }

    /**
     * Facilitates the process of the user
     * editing the IngredientList
     * @return true of the edit is successful, false if not
     */
    public boolean editIngredientList(){
        //init message
        igView.displayInitEdit();
        //recieve selected ingredient from the user
        IngredientController ingController = new IngredientController(igView.selectIngredient());
        //run edit ingredient process
        if(ingController.editIngredient()){
            //display success message
            igView.displayEditSuccess();
            return true;
        }
        return false;
    }

}
