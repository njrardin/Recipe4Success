package it326.r4s.controller;

import it326.r4s.model.FoodItem;
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

    public void executeView() {
        glView.execute();
    }

    public void printGroceryList() {
        //TODO: req 20
    }

    public void exportGroceryList() {
        //TODO: req 20
    }

    public void addItem() {
        //TODO: req 21
    }

    public void removeItem() {
        //TODO: req 22
    }

    public void moveToPantry() {
        //TODO: req 23
    }

    public void organizeGroceryList() {
        //TODO: req 24
    }

    public void viewGroceryList() {

    }
}
