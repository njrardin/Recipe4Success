package it326.r4s.controller;

import java.util.ArrayList;

import it326.r4s.model.Recipe;
import it326.r4s.model.Review;
import it326.r4s.model.User;
import it326.r4s.model.Review.Rating;
import it326.r4s.view.RecipeView;
import it326.r4s.view.RecipeView.RecipeBuilderView;
/**
 * Controller for R4S Recipe
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class RecipeController implements CLI_Controller{
    
    public Recipe recipe;
    public RecipeView recipeView;
    
    public RecipeController(Recipe recipe){
        this.recipe = recipe;
        this.recipeView = new RecipeView(this);
    }

    public RecipeView getRecipeView(){
        return recipeView;
    }

    public void executeView() {
        recipeView.execute();
    }

    public Recipe getRecipe(){
        return this.recipe;
    }
    
    public String getRecipeName() {
        return recipe.getName();
    }

    public String getRecipeDescription() {
        return recipe.getDescription();
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
        recipe.addReview(newReview);
    }

    public void editRecipe(){
        //TODO: implement
    }

	public void exportRecipe() {
        //TODO: This is Alex's problem
	}

	public void deleteRecipe() {
        if(recipeView.deletionConfirmation()){
            UserController.getGlobalUser().getRecipeBook().removeRecipe(recipe);
        }
	}

    public ArrayList<String> getInstructions() {
        return recipe.getInstructions();
    }

    public IngredientListController getIngredientListController() {
        return new IngredientListController(recipe.getIngredientList());
    }

    public void adjustServingSize(int newServingSize) {
        recipe.setServingSize(newServingSize);
    }

    public static class RecipeBuilderController {

        private RecipeBuilderView rBuildView;

        public RecipeBuilderController(){
            this.rBuildView = new RecipeBuilderView(this);
        }

        public Recipe buildUserRecipe(){

            

            return null; //TODO: implement
        }
    }

}
