package it326.r4s.view;

import it326.r4s.controller.PantryController;
import it326.r4s.controller.UnitController;
import it326.r4s.model.Ingredient;
import it326.r4s.model.IngredientList;
import it326.r4s.model.UnitConverter.Unit;
import it326.r4s.view.utilities.DisplayUtils;
import it326.r4s.view.utilities.InputAccess;
/**
 * View for R4S Pantry
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class PantryView implements R4SMenu{
    
    private PantryController pantryController;

    public PantryView(PantryController pantryController){
        this.pantryController = pantryController;
    }

    
	public void displayHeader() {
        System.out.println(DisplayUtils.getHeader("Pantry"));
	}


    /**
     * Displays the pantry to the screen
     */
	public void displayPantry() {
        System.out.println("Pantry:");
        System.out.println(DisplayUtils.HYPHEN_DIVIDER);
        if(pantryController.getIngredientListController().getIngredientList().getIngredients().isEmpty()){
            System.out.println("\nThe pantry is currently empty\n");
        }
        else{
            pantryController.getIngredientListController().getIngredientListView().displayIngredients();
            System.out.println();
        }
        System.out.println(DisplayUtils.HYPHEN_DIVIDER);
	}

    /**
     * Allows the user to select one of a series of options
     * @return an int representing the selected option
     */
    public int getMenuOptionSelection(){
        String title = "Pantry Options";
        String prompt = "What would you like to do?";
        String[] options = {
            "Add an Ingredient to My Pantry",
            "Remove an Item from My Pantry",
            "Remove All Ingredients in a Recipe from the Pantry",
            "List Recipes Makable with the Ingredients in My Pantry",
            "Go back"
        };
        InputAccess inputAccess = new InputAccess();
        return inputAccess.getOptionSelection(title, prompt, options);
    }
    
    /**
     * Gets an ingredient from the user
     * @return the ingredientlist
     */
    public IngredientList getNewIngredientsFromUser() {
        System.out.println("Alright! Let's add some ingredients to your pantry.");
 
        InputAccess inputAccess = new InputAccess();
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
                System.out.print("What is the first ingredient? : ");
            }
            else{
                System.out.print("What is the next ingredient? : ");
            }
            ingredientName = inputAccess.getInputLine().toLowerCase();
 
            //get the unit
            System.out.println("What is the unit of measure for " + ingredientName + "?");
            unit = UnitController.getUnit();
 
            //get the quantity
            System.out.print("How many " + unit.stringRep + "s are needed? : ");
            ingredientQuantity = -1;
            do{
                try{
                    ingredientQuantity = Double.parseDouble(inputAccess.getInputLine());
                    break;
                } catch (Exception e) {
                    System.out.print("Please select an option by typing the corresponding number: ");
                    continue;
                }
            } while(true);
            
            //confirm accuracy
            System.out.print("You provided ingredient #" + ingredientNum + " as\n\n \"" 
 
            + ingredientQuantity + " " + unit.stringRep + "s of " + ingredientName +
 
            "\"\n\n is this correct? (Y/N) : ");
            resp = inputAccess.getInputLine().toLowerCase();
            if(resp.equals("y")){
 
                ingredientList.addIngredient(new Ingredient(ingredientName, ingredientQuantity, unit));
                ingredientNum++;
            }
            else{
                continue;
            }
            
            //check to see if the user wishes to add another step
            do {
                System.out.print("Would you like to add another ingredient? (Y/N) : ");
                resp = inputAccess.getInputLine().toLowerCase();
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
         return pantryController.getIngredientListController().getIngredientListView().selectIngredient();
     }

}
