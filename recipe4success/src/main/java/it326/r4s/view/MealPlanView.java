package it326.r4s.view;

import java.util.Scanner;

import it326.r4s.controller.MealPlanController;

/**
 * View for R4S MealPlanner
 * @author Zach Plattner (zmplatt@ilstu.edu)
 * @date 4/26/22
 */
public class MealPlanView implements CLI_View{

    private MealPlanController mealPlanController;

    public MealPlanView(MealPlanController mealPlanController){
        this.mealPlanController = mealPlanController;
    }

    public void execute() {
        String input = "";
        Scanner scan = ViewUtilities.scan;
        displayMealPlan();
        displayMealPlanOptions();

        input = scan.nextLine().toLowerCase();
        System.out.println();
        while(true){
            switch(input) {
            case "1":
                mealPlanController.addRecipeToMP();
                break;
            case "2":
                mealPlanController.removeRecipeFromMP();
                break;
            case "3":
                mealPlanController.setMealPlanSS(this.getNewServingSize());;
                break;
            case "4":
                mealPlanController.addAllIngredientsToGroceryList();;
                break;
            case "5":
                mealPlanController.exportMealPlan();
                break;
            case "6":
                mealPlanController.deleteMealPlan();
                break;
            case "7":
                displayMealPlan();
                break;
            case "8":
                return;
            case "options":
                displayMealPlanOptions();
                break;
            case "back":
                return;
            default:
                System.out.println("Invalid input, please try again\n");
            }
            displayMealPlanOptions();
        }
    }

    private void displayMealPlan() {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Name: " + mealPlanController.getMealPlan().getMealPlanName());
        System.out.println("Description: " + mealPlanController.getMealPlan().getMealPlanDescription());
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
        System.out.println("                             -- Meal Plan Options --                                ");
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

    public void displayOneline() {
    }
}
