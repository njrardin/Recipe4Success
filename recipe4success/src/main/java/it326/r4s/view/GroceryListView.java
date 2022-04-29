package it326.r4s.view;

import java.util.Scanner;

import it326.r4s.controller.GroceryListController;
/**
 * View for R4S GroceryList
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class GroceryListView implements CLI_Menu{
    
    //*Instance Variable*\\
    private GroceryListController glController;

    //*Controller*\\
    /**
     * Constuctor for R4S's GroceryListView
     * @param glController - the GrocerylistView's controller
     */
    public GroceryListView(GroceryListController glController){
        this.glController = glController;
    }

    //*Methods\\
    /**
     * Allows the user to select one of a series of options
     * @return an int representing the selected option
     */
    public int getMenuOptionSelection(){
        return -1; //TODO: implement
    }
}
