package it326.r4s.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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

        input = scan.nextLine().toLowerCase();
        System.out.println();
        while(true){
            switch (input) {
                case "1":
                    recipeController.editRecipe();
                    break;
                case "2":
                    recipeController.addReview(UserController.getGlobalUser());
                    break;
                case "3":
                    recipeController.exportRecipe();
                    break;
                case "4":
                    recipeController.deleteRecipe();
                    break;
                case "5":
                    displayRecipe();
                    break;
                case "6":
                    return;
                case "options":
                    break;
                case "back":
                    return;
                default:
                    System.out.println("Invalid input, please try again\n");
            }
            displayRecipe();
            displayRecipeOptions();
        }
        //Display things and at some point utilize the following methods
        // rateRecipe(theRecipe, Scanner scan);
        // deleteRecipe(theRecipe);
        // editRecipe(theRecipe);
    }

    public void displayRecipe(){
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Name: " + recipeController.getRecipe().getName());
        System.out.println("Description: " + recipeController.getRecipe().getDescription());
        System.out.println("Serving Size: " + recipeController.getRecipe().getServingSize());
        System.out.println("Created on: " + recipeController.getRecipe().getCreatedOn());
        System.out.println();
        System.out.println("Ingredients: ");
        displayIngredients();
        System.out.println();
        System.out.println("Instructions: ");
        displayInstructions();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");   
    } //TODO behaviour to handle null values and format date better.
     
    
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

    public void displayRecipeOptions(){
        System.out.println("");
        System.out.println("                               -- Recipe Options --                                  ");
        System.out.println("");
        System.out.println("1) Edit recipe");
        System.out.println("2) Rate this recipe");
        System.out.println("3) Export this recipe");
        System.out.println("4) Delete this recipe");
        System.out.println("5) Re-Display Recipe");
        System.out.println("6) Go back");
        System.out.println();
    }

    public int getReviewRating(){
        Scanner scan = new Scanner(System.in);
        int acceptableRatings[] = {1,2,3,4,5};
        int ratingNum;

        do{
            System.out.println("How many stars would you like to rate this recipe? (1, 2, 3, 4, or 5)");
            ratingNum = Integer.parseInt(scan.nextLine());
        } while (Arrays.asList(acceptableRatings).contains(ratingNum));

        System.out.println("You have successfully rated " + recipeController.getRecipeName() + " with a total of " + ratingNum + "/5 stars.");
        scan.close();
        return ratingNum;
    }

    public void displayOneline() {
        System.out.println(recipeController.getRecipe().toString());
    }

}
