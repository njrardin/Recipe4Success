package it326.r4s.controller;

import it326.r4s.model.GroceryList;
import it326.r4s.view.GroceryListView;

public class GroceryListController {

    private GroceryList groceryList;
    private GroceryListView glView;

    public GroceryListController(GroceryList groceryList) {
        this.groceryList = groceryList;
        this.glView = new GroceryListView(this);
    }

    public void executeView() {
        glView.execute();
    }
    
}
