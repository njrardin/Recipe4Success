package it326.r4s.view;

import it326.r4s.controller.MealPlanController;
import it326.r4s.view.utilities.InputAccess;
/**
 * View for R4S MealPlanner
 * @author Zach Plattner (zmplatt@ilstu.edu) and Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class MealPlanView implements R4SMenu {

    //*Instance Variables*\\
    private MealPlanController mealPlanController;

    //*Constructor*\\
    /**
     * Constructor for R4S's MealPlanView
     * @param mealPlanController - the MealPlanView's controller
     */
    public MealPlanView(MealPlanController mealPlanController){
        this.mealPlanController = mealPlanController;
    }

    //*Methods*\\
    /**
     * Displays the meal plan to the screen
     */
    public void displayMealPlan() {
        System.out.println("\n\n-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Name: " + mealPlanController.getMealPlan().getMealPlanName());
        System.out.println("Description: " + mealPlanController.getMealPlan().getMealPlanDescription());
        System.out.println("Created on: " + mealPlanController.getMealPlan().getMealPlanDate());
        if(mealPlanController.getMealPlan().getMPServingSize()!=0) {
        System.out.println("Serves: " + mealPlanController.getMealPlan().getMPServingSize());
        }
        System.out.println();
        mealPlanController.getAuthorController().getRecipeBookController().getRecipeBookView().displayRecipes(mealPlanController.getRecipeControllers());
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");   
    }
    //TODO: behavior to handle null values and format date better

    /**
     * Allows the user to select one of a series of options
     * @return an int representing the selected option
     */
    public int getMenuOptionSelection(){
        String title = "Meal Plan: " + mealPlanController.getMealPlan().getMealPlanName();
        String prompt = "What would you like to do?";
        String[] options = {
            "Add Recipe to this Mealplan",
            "Remove Recipe from this Mealplan",
            "Open a Recipe in this Mealplan",
            "Set Mealplan Serving Size",
            "Move this Mealplan's Ingredients to My Grocery List",
            "Export this Mealplan",
            "Delete this Mealplan",
            "Go back"
        };
        InputAccess inputAccess = new InputAccess();
        return inputAccess.getOptionSelection(title, prompt, options);
    }

    /**
     * Asks of the user a confirmation of deletion
     * @return true if confirmed to delete, false if deletion denied
     */
    public boolean deletionConfirmation() {
        InputAccess inputAccess = new InputAccess();
        String response = "";
        do{
            System.out.print("Are you sure you want to delete " + mealPlanController.getMealPlan().getMealPlanName() + " from your meal planner? (Y/N) : ");
            response = inputAccess.getInputLine().toLowerCase();
        }  while ( !(response.equals("y") || response.equals("n") ));

        if(response.equals("n")){
            return false;
        }
        else{
            System.out.println("...deleting " + mealPlanController.getMealPlan().getMealPlanName());
            return true;
        }
    }

    /**
     * Confirms if the user wants to add all ingredients in the meal plan to the grocery list
     * @return true if confirmed, false otherwise
     */
    public boolean addToGroceryListConfirmation() {
        InputAccess inputAccess = new InputAccess();
        String response = "";
        do{
            System.out.print("Are you sure you want to add all ingredients from this meal plan to your grocery list? (Y/N) : ");
            response = inputAccess.getInputLine().toLowerCase();
        }  while ( !(response.equals("y") || response.equals("n") ));

        if(response.equals("n")){
            return false;
        }
        return true;
    }

    /**
     * Confirms if the user wants to set all meals in the meal plan to this serving size
     * @param newServingSize
     * @return true if confirmed, false otherwise
     */
    public boolean adjustMPServingSizeConfirmation(int newServingSize) {
        InputAccess inputAccess = new InputAccess();
        String response = "";
        do{
            System.out.print("Are you sure you want to change all recipes in this meal plan to a serving size of " + newServingSize + "? (Y/N) : ");
            response = inputAccess.getInputLine().toLowerCase();
        }  while ( !(response.equals("y") || response.equals("n") ));

        if(response.equals("n")){
            return false;
        }
        return true;
    }

    /**
     * Gets from the user a new serving size
     * for a mealplan
     * @return int servingSize
     */
    public int getNewServingSize() {
        InputAccess inputAccess = new InputAccess();
        int servingSize = -1;

        do{
            System.out.print("What is the new serving size? : ");
            try{
                servingSize = Integer.parseInt(inputAccess.getInputLine());
            } catch (NumberFormatException e) {
                continue;
            }
            if(servingSize < 0){
                System.out.println("Serving size must be above 0");
            }
        } while (servingSize < 0);

        return servingSize;
    }

    /**
     * Displays the mealplan in a one line format
     */
    public void displayOneLine() {
        System.out.println(mealPlanController.getMealPlan().getMealPlanName() + ": " + mealPlanController.getMealPlan().getMealPlanDescription());
    }

}
