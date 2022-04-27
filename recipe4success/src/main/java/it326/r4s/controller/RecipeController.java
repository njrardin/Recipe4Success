package it326.r4s.controller;

import it326.r4s.model.Recipe;
import it326.r4s.model.Review;
import it326.r4s.model.User;
import it326.r4s.model.Review.Rating;
import it326.r4s.view.RecipeView;
/**
 * Controller for R4S Recipe
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class RecipeController implements CLI_Controller{
    
    public Recipe theRecipe;
    public RecipeView recipeView;
    
    public RecipeController(Recipe recipe){
        this.theRecipe = recipe;
        this.recipeView = new RecipeView(this);
    }

    public RecipeView getRecipeView(){
        return recipeView;
    }

    public void executeView() {
        recipeView.execute();
    }

    public Recipe getRecipe(){
        return this.theRecipe;
    }
    
    public String getRecipeName() {
        return theRecipe.getName();
    }

    public String getRecipeDescription() {
        return theRecipe.getDescription();
    }

    public void addReview(User theUser){
        int ratingNum = recipeView.getReviewRating();
        Rating rating = null;

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
        }
        Review newReview = new Review(UserController.getGlobalUser(), rating);
        theRecipe.addReview(newReview);
    }

    public void editRecipe(){
        //TODO: implement
    }

	public void exportRecipe() {
        //TODO: This is Alex's problem lmao
	}

	public void deleteRecipe() {
        //TODO: implement
	}


}
