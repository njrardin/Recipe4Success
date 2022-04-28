package it326.r4s.controller;

import it326.r4s.model.GroceryList;
import it326.r4s.view.GroceryListView;

/**
 * Controller for R4S GroceryList
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class GroceryListController {

    private GroceryList groceryList;
    private GroceryListView glView;

    public GroceryListController(GroceryList groceryList) {
        this.groceryList = groceryList;
        this.glView = new GroceryListView(this);
    }

    public void openGroceryList() {
        glView.getMenuOptionSelection();
    }
    
}
