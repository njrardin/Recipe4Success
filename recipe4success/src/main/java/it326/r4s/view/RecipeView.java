package it326.r4s.view;

import java.util.Arrays;
import java.util.Scanner;

import it326.r4s.controller.RecipeController;
import it326.r4s.model.Recipe;
/**
 * View for R4S Recipe
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class RecipeView implements CLI_View{

    private RecipeController rController;

    public RecipeView(RecipeController rController){
        this.rController = rController;
    }

    public void execute(){
        Scanner scan = new Scanner(System.in);
        //Display things and at some point utilize the following methods
        // rateRecipe(theRecipe, Scanner scan);
        // deleteRecipe(theRecipe);
        // editRecipe(theRecipe);
    }

    public int getReviewRating(){
        Scanner scan = new Scanner(System.in);
        int acceptableRatings[] = {1,2,3,4,5};
        int ratingNum;

        do{
            System.out.println("How many stars would you like to rate this recipe? (1, 2, 3, 4, or 5)");
            ratingNum = Integer.parseInt(scan.nextLine());
        } while (Arrays.asList(acceptableRatings).contains(ratingNum));

        System.out.println("You have successfully rated " + rController.getRecipeName() + " with a total of " + ratingNum + "/5 stars.");
        scan.close();
        return ratingNum;
    }

    public void displayOneline() {
        System.out.println(rController.getRecipe().toString());
    }

}
