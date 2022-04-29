package it326.r4s.controller;

import it326.r4s.model.GroceryList;
import it326.r4s.model.Pantry;
import it326.r4s.view.GroceryListView;

/**
 * Controller for R4S GroceryList
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class GroceryListController {

    //*Instance variables*\\
    private GroceryList groceryList;
    private GroceryListView glView;

    //*Constructor*\\
    /**
     * Constructor for R4S's GroceryListController
     * @param groceryList - the controller's GroceryList object
     */
    public GroceryListController(GroceryList groceryList) {
        this.groceryList = groceryList;
        this.glView = new GroceryListView(this);
    }

    //*Methods*\\
    public IngredientListController getIngredientListController() {
		return new IngredientListController(groceryList.getIngredientList());
	}

    /**
     * Launches the GroceryListView's main menu 
     * to get a user option selection
     * and then takes the appropriate action
     */
    public void openGroceryList() {
        glView.displayHeader();
        glView.displayGroceryList();
        int option;
        while (true) {
            option = glView.getMenuOptionSelection();
            switch (option) {
                case 1:
                    addIngredient();
                    break;
                case 2:
                    removeIngredient();
                    break;
                case 3:
                    transferToPantry();
                    break;
                case 4:
                    organizeGroceryList();
                    break;
                case 5:
                    exportGroceryList();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid input, please try again\n");
            }
            glView.displayHeader();
            glView.displayGroceryList();
        }
    }

    /**
     * Facilitats the process of the user
     * adding an ingredient to the grocerylist
     */
    public void addIngredient() {
        groceryList.addIngredientList(glView.getNewIngredientsFromUser());
    }
    
    /**
     * Facilitats the process of the user
     * removing an ingredient from the grocerylist
     */
    public void removeIngredient() {
        groceryList.removeIngredient(glView.getIngredientRemovalFromUser());
    }

    /**
     * Facilitats the process of the user
     * transferring items to pantry
     */
    public void transferToPantry() {
        if(glView.confirmTransfer()){
            //move ingredients to the pantry
            Pantry thePantry = UserController.getUserController().getGlobalUser().getPantry();
            thePantry.addIngredientList(groceryList.getIngredientList());
            //remove all of the ingredients in the grocery list
            groceryList.getIngredientList().makeEmpty();
            glView.displayTransferSuccess();
        }
        else{
            glView.displayTransferCancel();
        }
    }

    /**
     * Facilitates the process of the user
     * organizing the items on their grocery list
     */
    public void organizeGroceryList() {
        
    }

    /**
     * Facilitates the process of the user
     * exporting their grocery list
     */
    public void exportGroceryList(){

    }
}
