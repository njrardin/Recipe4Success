package it326.r4s.view;

import java.util.Arrays;
import java.util.Scanner;

import it326.r4s.model.Recipe;
import it326.r4s.model.Review;
import it326.r4s.model.User;
import it326.r4s.model.Review.Rating;

public class RecipeView {

    public static void executeRecipeView(Recipe theRecipe) {
        Scanner scan = new Scanner(System.in);
        //Display things and at some point utilize the following methods
        // rateRecipe(theRecipe, Scanner scan);
        // deleteRecipe(theRecipe);
        // editRecipe(theRecipe);
    }

    public static void rateRecipe(Recipe theRecipe, Scanner scan){
        User theUser = User.getUser();
        int acceptableRatings[] = {1,2,3,4,5};
        int ratingNum;
        Review.Rating rating;
        do{
            System.out.println("How many stars would you like to rate this recipe? (1, 2, 3, 4, or 5)");
            ratingNum = Integer.parseInt(scan.nextLine());
        } while (Arrays.asList(acceptableRatings).contains(ratingNum));
        switch (ratingNum){
            case 1:
                rating = Rating.ONE;
                break;
            case 2:
                rating = Rating.TWO;
                break;
            case 3:
                rating = Rating.THREE;
                break;
            case 4:
                rating = Rating.FOUR;
                break;
            case 5:
                rating = Rating.FIVE;
                break;
            default:
                rating = Rating.ONE;
        }
        theRecipe.addReview(new Review(theUser, rating)); //TODO: NEED TO ACTUALLY AFFECT THE RECIPE IN USER
        System.out.println("You have successfully rated " + theRecipe.getName() + " with a total of " + ratingNum + "/5 stars.");
    }

    public static void deleteRecipe(Recipe theRecipe, Scanner scan){

    }

    public static void editRecipe(Recipe theRecipe, Scanner scan){

    }

}
