package it326.r4s.view;

import java.util.Scanner;

import it326.r4s.controller.GroceryListController;
/**
 * View for R4S GroceryList
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class GroceryListView implements CLI_View{
    
    private GroceryListController glController;

    public GroceryListView(GroceryListController glController){
        this.glController = glController;
    }

    public void execute(){
        
    }
}
