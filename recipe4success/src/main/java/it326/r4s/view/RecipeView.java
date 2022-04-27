package it326.r4s.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

import it326.r4s.controller.RecipeController;
import it326.r4s.controller.UserController;
import it326.r4s.model.Recipe;

/**
 * View for R4S Recipe
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class RecipeView implements CLI_View{

    private RecipeController recipeController;

    public RecipeView(RecipeController recipeController){
        this.recipeController = recipeController;
    }
    
    public void execute(){
        String input = "";
        Scanner scan = ViewUtilities.scan;
        displayRecipe();
        displayRecipeOptions();

        while(true){
            System.out.println("Please type the number corresponding to the option you wish to select: ");
            System.out.println("(to see the options again, type \"options\")");
    
            input = scan.nextLine().toLowerCase();
            System.out.println();
            switch (input) {
                case "1":
                    recipeController.editRecipe();
                    break;
                case "2":
                    recipeController.addReview(UserController.getGlobalUser());
                    break;
                case "3":
                    recipeController.adjustServingSize(this.getNewServingSize());
                    break;
                case "4":
                    recipeController.exportRecipe();
                    break;
                case "5":
                    recipeController.deleteRecipe();
                    return;
                case "6":
                    displayRecipe();
                    break;
                case "7":
                    return;
                case "options":
                displayRecipeOptions();
                    break;
                case "back":
                    return;
                default:
                    System.out.println("Invalid input, please try again\n");
            }
            displayRecipe();
            displayRecipeOptions();
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

    public void displayRecipe(){
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Name: " + recipeController.getRecipe().getName());
        System.out.println("Description: " + recipeController.getRecipe().getDescription());
        System.out.println("Serving Size: " + recipeController.getRecipe().getServingSize());
        System.out.println("Created on: " + recipeController.getRecipe().getCreatedOn());
        System.out.println("Your rating: " + retUserRating() + " /5 stars");
        System.out.println();
        System.out.println("Ingredients: ");
        displayIngredients();
        System.out.println();
        System.out.println("Instructions: ");
        displayInstructions();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");   
    } 
    //TODO: behaviour to handle null values and format date better
    //TODO: also add a rating display
     
    
    private void displayIngredients() {
        recipeController.getIngredientListController().getIngredientListView().displayIngredients();
    }
    
    private void displayInstructions() {
        ArrayList<String > instructions = recipeController.getInstructions();

        int instNum = 1;
        for(String instruction: instructions){
            System.out.println(instNum + ") " + instruction);
            instNum++;
        }
    }

    private String retUserRating(){
        try{
            return String.valueOf(recipeController.getRecipe().getReviews().get(0).getRatingValue());
        } catch (Exception e) {
            return "none";
        }
    }

    public void displayRecipeOptions(){
        System.out.println("");
        System.out.println("                               -- Recipe Options --                                  ");
        System.out.println("");
        System.out.println("1) Edit recipe");
        System.out.println("2) Rate this recipe");
        System.out.println("3) Adjust serving size");
        System.out.println("4) Export this recipe");
        System.out.println("5) Delete this recipe");
        System.out.println("6) Re-Display Recipe");
        System.out.println("7) Go back");
        System.out.println();
    }

    public int getReviewRating(){
        Scanner scan = ViewUtilities.scan;
        int acceptableRatings[] = {1,2,3,4,5};
        int ratingNum;

        do{
            System.out.println("How many stars would you like to rate this recipe? (1, 2, 3, 4, or 5)");
            ratingNum = Integer.parseInt(scan.nextLine());
        } while (Arrays.asList(acceptableRatings).contains(ratingNum));

        System.out.println("You have successfully rated " + recipeController.getRecipeName() + " with a total of " + ratingNum + "/5 stars.");
        return ratingNum;
    }

    public void displayOneline() {
        System.out.println(recipeController.getRecipe().toString());
    }

    public boolean deletionConfirmation() {
        Scanner scan = ViewUtilities.scan;
        String input = "";
        do{
            System.out.println("Are you sure you want to delete " + recipeController.getRecipeName() + " from your recipe book? (Y/N)");
            input = scan.nextLine().toLowerCase();
        }  while ( !(input.equals("y") || input.equals("n") ));

        if(input.equals("n")){
            return false;
        }
        else{
            System.out.println("...deleting " + recipeController.getRecipeName());
            return true;
        }

    }

}
