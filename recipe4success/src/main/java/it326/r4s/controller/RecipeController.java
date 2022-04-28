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
public class RecipeController {
    
    public Recipe recipe;
    public RecipeView recipeView;
    
    public RecipeController(Recipe recipe){
        this.recipe = recipe;
        this.recipeView = new RecipeView(this);
    }

    public RecipeView getRecipeView(){
        return recipeView;
    }

    public Recipe getRecipe(){
        return this.recipe;
    }

    public void openRecipe(){
        recipeView.displayRecipe();
        int option;
        while(true){
            option = recipeView.getMenuOptionSelection();

            switch (option) {
                case 1:
                    editRecipe();
                    break;
                case 2:
                    addReview(UserController.getUserController().getGlobalUser());
                    break;
                case 3:
                    adjustServingSize(recipeView.getNewServingSize());
                    break;
                case 4:
                    exportRecipe();
                    break;
                case 5:
                    deleteRecipe();
                    return;
                case 6:
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid input, please try again\n");
            }
            recipeView.displayRecipe();
        }
    }

    public void editRecipe(){
        int editOption = recipeView.getEditOptionSelection(recipe.getName());

        switch(editOption){
            case 1:
                recipe.setName(RecipeBuilderView.getRecipeNameFromUser());
                break;
            case 2:
                recipe.setDescription(RecipeBuilderView.getDescriptionFromUser());
                break;
            case 3:
                recipe.adjustServingSize(RecipeBuilderView.getServingSizeFromUser());
                break;
            case 4:
                recipe.setIngredientList(RecipeBuilderView.getIngredientsFromUser());
                break;
            case 5:
                recipe.setInstructions(RecipeBuilderView.getInstructionsFromUser());
            case 6:
                return;
        }
        recipeView.displayUpdateSuccess();
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
        Review newReview = new Review(UserController.getUserController().getGlobalUser(), rating);
        recipe.addReview(newReview);
    }

    public void adjustServingSize(int newServingSize) {
        recipe.adjustServingSize(newServingSize);
    }

	public void exportRecipe() {
        //TODO: This is Alex's problem
	}

	public void deleteRecipe() {
        if(recipeView.deletionConfirmation()){
            UserController.getUserController().getGlobalUser().getRecipeBook().removeRecipe(recipe);
        }
	}

    public ArrayList<String> getInstructions() {
        return recipe.getInstructions();
    }

    public IngredientListController getIngredientListController() {
        return new IngredientListController(recipe.getIngredientList());
    }



    /**
     * Controller for R4S RecipeBuilder
     * @author Nate Rardin (njrardi@ilstu.edu)
     * @date 4/27/22
     */
    public static class RecipeBuilderController {

        private RecipeBuilderView rBuildView;

        public RecipeBuilderController(){
            this.rBuildView = new RecipeBuilderView(this);
        }

        public Recipe buildUserRecipe() throws RuntimeException{

            Recipe newRecipe;
            rBuildView.displayRecipeBuildInit();

            //build name
            Recipe.RecipeBuilder rBuild = new Recipe.RecipeBuilder(rBuildView.getRecipeNameFromUser());
            
            rBuild.setDescription(rBuildView.getDescriptionFromUser());

            rBuild.setServingSize(rBuildView.getServingSizeFromUser());

            rBuild.setInstructions(rBuildView.getInstructionsFromUser());

            rBuild.setIngredientList(rBuildView.getIngredientsFromUser());

            rBuild.setCategories(rBuildView.getCategoriesFromUser());

            if (rBuildView.confirmBuild()){
                newRecipe = rBuild.build();
            }
            else{
                throw new RuntimeException();
            } //TODO: patch in edit system here

            return newRecipe;
        }
    }

}
