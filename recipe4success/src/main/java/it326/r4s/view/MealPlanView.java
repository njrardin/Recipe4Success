package it326.r4s.view;

import java.util.Scanner;

import it326.r4s.controller.MealPlanController;

/**
 * View for R4S MealPlanner
 * @author Zach Plattner (zmplatt@ilstu.edu) and Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class MealPlanView implements CLI_Menu {

    //*Instance Variables*\\
    private MealPlanController mealPlanController;

    //*Constructor*\\
    /**
     * Constructor for R4S's MealPlanview
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
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Name: " + mealPlanController.getMealPlan().getMealPlanName());
        System.out.println("Description: " + mealPlanController.getMealPlan().getMealPlanDescription());
        if(mealPlanController.getMealPlan().getServingSize() == 1){
            System.out.println("Serving size: " + mealPlanController.getMealPlan().getServingSize() + " person");
        } else {
            System.out.println("Serving size: " + mealPlanController.getMealPlan().getServingSize() + " people");
        }
        System.out.println("Created on: " + mealPlanController.getMealPlan().getMealPlanDate());
        System.out.println();
        System.out.println("Recipes: ");
        //displayRecipes();
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");   
    }
    //TODO: behaviour to handle null values and format date better

    public void displayMealPlanOptions(){
        System.out.println();
        System.out.println("                             -- Mealplan Options --                                ");
        System.out.println("");
        System.out.println("1) Add Recipe to Meal Plan");
        System.out.println("2) Remove Recipe from Meal Plan");
        System.out.println("3) Set Meal Plan Serving Size");
        System.out.println("4) Move this Meal Plan's Ingredients to Your Grocery List");
        System.out.println("5) Export this Meal Plan");
        System.out.println("6) Delete this Meal Plan");
        System.out.println("7) Re-Display Meal Plan");
        System.out.println("8) Go back");
        System.out.println();
    }

    /**
     * Allows the user to select one of a series of options
     * @return an int representing the selected option
     */
    public int getMenuOptionSelection(){
        String title = "Mealplan: " + mealPlanController.getMealPlan().getMealPlanName();
        String prompt = "What would you like to do?";
        String[] options = {
            "Add Recipe to Mealplan",
            "Remove Recipe from Mealplan",
            "Set Mealplan Serving Size",
            "Move this Mealplan's Ingredients to My Grocery List",
            "Export this Mealplan",
            "Delete this Mealplan",
            "Re-Display Recipe",
            "Go back"
        };
        return ViewUtilities.getOptionFromCLI(title, prompt, options);
    }

    /**
     * Asks of the user a confirmation of deletion
     * @return true if confirmed to delete, false if deletion denied
     */
    public boolean deletionConfirmation() {
        Scanner scan = ViewUtilities.scan;
        String input = "";
        do{
            System.out.println("Are you sure you want to delete " + mealPlanController.getMealPlan().getMealPlanName() + " from your recipe book? (Y/N)");
            input = scan.nextLine().toLowerCase();
        }  while ( !(input.equals("y") || input.equals("n") ));

        if(input.equals("n")){
            return false;
        }
        else{
            System.out.println("...deleting " + mealPlanController.getMealPlan().getMealPlanName());
            return true;
        }
    }

    private int getNewServingSize() {
        Scanner scan = ViewUtilities.scan;
        int servingSize = -1;

        do{
            System.out.println("What is the new serving size?");
            try{
                servingSize = Integer.parseInt(scan.nextLine());
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
    public void displayOneline() {
        System.out.println(mealPlanController.getMealPlan().getMealPlanName() + ": " + mealPlanController.getMealPlan().getMealPlanDescription());
    }

}
