package it326.r4s.controller;

import it326.r4s.model.Recipe;
import it326.r4s.model.Review;
import it326.r4s.model.User;
import it326.r4s.model.Review.Rating;
import it326.r4s.view.RecipeView;

public class RecipeController {
    
    public Recipe theRecipe;
    public RecipeView recipeView;

    public RecipeController(Recipe recipe){
        this.theRecipe = recipe;
        this.recipeView = new RecipeView(this);
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

    public Recipe getRecipe(){
        return this.theRecipe;
    }

    public String getRecipeName() {
        return null;
    }
}
