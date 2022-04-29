package it326.r4s.view;

import java.util.Scanner;

import it326.r4s.controller.GroceryListController;
import it326.r4s.controller.IngredientListController;
import it326.r4s.controller.UnitController;
import it326.r4s.model.Ingredient;
import it326.r4s.model.IngredientList;
import it326.r4s.model.UnitConverter.Unit;
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
        return ViewUtilities.getOptionFromCLI(title, prompt, options);
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

       Scanner scan = ViewUtilities.scan;
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
           ingredientName = scan.nextLine().toLowerCase();

           //get the unit
           System.out.println("What is the unit of measure for " + ingredientName + "?");
           unit = UnitController.getUnit();

           //get the quantity
           System.out.println("How many " + unit.stringRep + "s are needed?");
           ingredientQuantity = Double.parseDouble(scan.nextLine());
           
           //confirm accuracy
           System.out.println("You provided ingredient #" + ingredientNum + " as\n\n \"" 

           + ingredientQuantity + " " + unit.stringRep + "s of " + ingredientName +

           "\"\n\n is this correct? (Y/N)");
           resp = scan.nextLine().toLowerCase();
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
               resp = scan.nextLine().toLowerCase();
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
        Scanner scan = ViewUtilities.scan;
        String input = "";
        do{
            System.out.println("Are you sure you want to transfer all the ingredients to your pantry? (Y/N)");
            input = scan.nextLine().toLowerCase();
        }  while ( !(input.equals("y") || input.equals("n") ));

        if(input.equals("n")){
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

    /**
     * Displays a cancelation message for the transfer
     */
    public void displayTransferCancel(){
        System.out.println("Transfer cancelled.\n");
    }
}
