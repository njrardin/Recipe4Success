package it326.r4s.controller;

import it326.r4s.model.GroceryList;
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

    public void addIngredient() {
        groceryList.addIngredientList(glView.getNewIngredientsFromUser());
    }
    
    public void removeIngredient() {
        groceryList.removeIngredient(glView.getIngredientRemovalFromUser());
    }
    
    public void transferToPantry() {
    }

    public void organizeGroceryList() {

    }

    public void exportGroceryList(){

    }
}
