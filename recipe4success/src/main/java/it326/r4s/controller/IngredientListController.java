package it326.r4s.controller;

import it326.r4s.model.IngredientList;
import it326.r4s.view.IngredientListView;

/**
 * View for R4S Recipe
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/27/22
 */
public class IngredientListController {

    private IngredientList ingredientList;
    private IngredientListView igView;

    public IngredientListController(IngredientList ingredientList){
        this.ingredientList = ingredientList;
        this.igView = new IngredientListView(this);
    }

    public IngredientListView getIngredientListView(){
        return this.igView;
    }

    public IngredientList getIngredientList(){
        return this.ingredientList;
    }

}
