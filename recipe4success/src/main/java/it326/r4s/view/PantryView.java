package it326.r4s.view;

import it326.r4s.controller.PantryController;
/**
 * View for R4S Pantry
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class PantryView implements CLI_Menu{
    
    private PantryController pantryController;

    public PantryView(PantryController pantryController){
        this.pantryController = pantryController;
    }

    public int getMenuOptionSelection(){
        return -1; //TODO: implement]

    }
}
