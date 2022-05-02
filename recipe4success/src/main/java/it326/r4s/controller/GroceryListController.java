package it326.r4s.controller;

import it326.r4s.model.GroceryList;
import it326.r4s.model.Ingredient;
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
    private UserController userController;
    private PorterController<GroceryList> groceryListPorter;

    //*Constructor*\\
    /**
     * Constructor for R4S's GroceryListController
     * @param groceryList - the controller's GroceryList object
     */
    public GroceryListController(GroceryList groceryList, UserController userController) {
        this.groceryList = groceryList;
        this.glView = new GroceryListView(this);
        this.userController = userController;
        groceryListPorter = PorterController.of(GroceryList.class);
    }

    //*Methods*\\
    /**
     * Getter for the GroceryListController's GroceryList
     * @return the GroceryList object
     */
    public GroceryList getGroceryList(){
        return this.groceryList;
    }

    /**
     * Getter for the GroceryListController's GroceryListView
     * @return the GroceryListView object
     */
    public GroceryListView getGroceryListView(){
        return this.glView;
    }

    /**
     * Getter for the UserController that controls this GroceryListController
     * @return the GroceryListController object
     */
    public UserController getUserController(){
        return this.userController;
    }

    /**
     * Getter for the IngredientListController which controls the GroceryList's IngredientList
     * @return the IngredientListController
     */
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
        groceryList.addIngredients(glView.getNewIngredientsFromUser());
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
            Pantry thePantry = userController.getPantryController().getPantry();
            thePantry.addIngredients(groceryList.getIngredientList());
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
        //display use case initilization message
        glView.displayOrganizeInit();
        //print out grocery list and get the
        //selected ingredient toMove
        glView.askForToMove();
        Ingredient toMove = getIngredientListController().getIngredientListView().selectIngredient();
        //get a selected ingerdient after which to place toMove 
        glView.askForMoveAfter();
        Ingredient moveAfter = getIngredientListController().getIngredientListView().selectIngredient();
        //re-order the ingredients
        if(getIngredientListController().getIngredientList().reoganizeIngredients(toMove, moveAfter)){
            glView.displayReorganizeSuccess();
        }
        else{
            glView.displayReorganizeError();
        }
        //display a use case success message
    }

    /**
     * Facilitates the process of the user
     * exporting their grocery list
     */
    public void exportGroceryList(){
        groceryListPorter.exportTo(groceryList);
    }
}