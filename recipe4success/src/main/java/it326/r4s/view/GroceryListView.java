package it326.r4s.view;

import java.util.Scanner;

import it326.r4s.controller.GroceryListController;
import it326.r4s.controller.IngredientListController;
import it326.r4s.controller.UnitController;
import it326.r4s.model.Ingredient;
import it326.r4s.model.IngredientList;
import it326.r4s.model.UnitConverter.Unit;
import it326.r4s.view.utilities.DisplayUtils;
import it326.r4s.view.utilities.InputAccess;
/**
 * View for R4S GroceryList
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class GroceryListView implements R4SMenu{
    
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
     * Displays the header for the grocery list menu
     */
    public void displayHeader() {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("---                                                                               ---");
        System.out.println("---                               -- Grocery List --                              ---");
        System.out.println("---                                                                               ---");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
	}

    /**
     * Allows the user to select one of a series of options
     * @return an int representing the selected option
     */
    public int getMenuOptionSelection(){
        String title = "Grocery List Options";
        String prompt = "What would you like to do?";
        String[] options = {
            "Add an Item to the My Grocery List",
            "Remove an Item from My Grocery List",
            "Transfer Ingredients to My Pantry",
            "Organize the Grocery List order",
            "Export this Grocery List",
            "Go back"
        };

        InputAccess input = new InputAccess();
        return input.getOptionSelection(title, prompt, options);
    }

    /**
     * Displays the grocery list to the screen
     */
	public void displayGroceryList() {
        System.out.printf("%52s%n%n", "-- My Grocery List --");
        if(glController.getIngredientListController().getIngredientList().getIngredients().isEmpty()){
            System.out.println("The grocery list is currently empty\n");
        }
        else{
            glController.getIngredientListController().getIngredientListView().displayIngredients();
            System.out.println();
        }
	}

    /**
     * Gets an ingredient from the user
     * @return the ingredientlist
     */
    public IngredientList getNewIngredientsFromUser() {
       System.out.println("Alright! Let's add some ingredients to the list.");

       InputAccess input = new InputAccess();
       String resp = "";

       String ingredientName;
       double ingredientQuantity;
       Unit unit;

       IngredientList ingredientList = new IngredientList();

       //loop to allow multiple instructions to be added
       int ingredientNum = 1;
       System.out.println("Let's add the first ingredient.");
       while(true){
           //get ingredient name
           if(ingredientNum == 1){
               System.out.println("What is the first ingredient?\n");
           }
           else{
               System.out.println("What is the next ingredient?\n");
           }
           ingredientName = input.getInputLine().toLowerCase();

           //get the unit
           System.out.println("What is the unit of measure for " + ingredientName + "?");
           unit = UnitController.getUnit();

           //get the quantity
           System.out.println("How many " + unit.stringRep + "s are needed?");
           ingredientQuantity = Double.parseDouble(input.getInputLine());
           
           //confirm accuracy
           System.out.println("You provided ingredient #" + ingredientNum + " as\n\n \"" 

           + ingredientQuantity + " " + unit.stringRep + "s of " + ingredientName +

           "\"\n\n is this correct? (Y/N)");
           resp = input.getInputLine().toLowerCase();
           if(resp.equals("y")){

               ingredientList.addIngredient(new Ingredient(ingredientName, ingredientQuantity, unit));
               ingredientNum++;
           }
           else{
               continue;
           }
           
           //check to see if the user wishes to add another step
           do {
               System.out.println("Would you like to add another ingredient? (Y/N)");
               resp = input.getInputLine().toLowerCase();
           } while (!(resp.equals("y") || resp.equals("n")));
           
           if(resp.equals("n")){
               return ingredientList;
           }

       }
    }

    /**
     * Gets an ingredient from the user to remove
     * @return the ingredient
     */
	public Ingredient getIngredientRemovalFromUser() {
		return glController.getIngredientListController().getIngredientListView().selectIngredient();
	}

    public boolean confirmTransfer() {
        InputAccess input = new InputAccess();
        String response = "";
        do{
            System.out.println("Are you sure you want to transfer all the ingredients to your pantry? (Y/N)");
            response = input.getInputLine().toLowerCase();
        }  while ( !(response.equals("y") || response.equals("n") ));

        if(response.equals("n")){
            return false;
        }
        else{
            System.out.println("...transferring to pantry\n");
            return true;
        }
    }

    /**
     * Displays a success message for the transfer
     */
    public void displayTransferSuccess() {
        System.out.println("Ingredients have been successfully transferred!");
    }

    //Display methods associated with the re-organize grocery list use case
    public void displayTransferCancel(){
        System.out.println("Transfer cancelled.\n");
    }
    
    public void displayOrganizeInit() {
        System.out.println("Let's make sure your grocery list is ordered exactly how you want it!");
    }

    public void askForToMove() {
        System.out.println("\nWhich ingredient would you like to move?");
    }

    public void askForMoveAfter() {
        System.out.println("\nAfter which ingredient would you like to move your selected ingredient?");
    }

    public void displayReorganizeSuccess() {
        System.out.println("Grocery List successfully re-organized!");
    }

    public void displaReorganizeError() {
        System.out.println("Oops, looks like there was an error re-organizing the list.");
    }


}
