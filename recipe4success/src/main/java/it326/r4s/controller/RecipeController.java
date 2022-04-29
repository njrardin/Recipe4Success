package it326.r4s.controller;

import it326.r4s.model.Recipe;
import it326.r4s.model.Review;
import it326.r4s.model.User;
import it326.r4s.model.Review.Rating;
import it326.r4s.view.RecipeBookView;
import it326.r4s.view.RecipeView;
import it326.r4s.view.RecipeView.RecipeBuilderView;
/**
 * Controller for R4S Recipe
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class RecipeController {
    
    //*Instance Variables*\\
    public Recipe recipe;
    public RecipeView recipeView;
    
    //*Constructor*\\
    /**
     * Constructs a recipe controller from a given recipe
     * @param recipe
     */
    public RecipeController(Recipe recipe){
        this.recipe = recipe;
        this.recipeView = new RecipeView(this);
    }

    //*Methods*\\
    /**
     * Getter for the controller's recipeView
     * @return
     */
    public RecipeView getRecipeView(){
        return recipeView;
    }

    /**
     * Getter for the controller's recipe
     * @return
     */
    public Recipe getRecipe(){
        return this.recipe;
    }

    /**
     * Launches the recipeBookView to get a user option selection
     * and then takes the appropriate action
     */
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
                    adjustServingSize(RecipeBuilderView.getServingSizeFromUser());
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

    /**
     * Faciliates the process of the user
     * editing the recipe
     */
    public void editRecipe(){
        int editOption = recipeView.getEditOptionSelection();

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

    /**
     * Facilitates the process of the user
     * writing a review on a recipe
     * @param theUser - takes in the user object to associate the review with an author
     */
    public void addReview(User theUser){
        int ratingNum = recipeView.getRatingFromUser();
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

    /**
     * Facilitates the process of the user
     * adjusting the recipe's serving size
     * @param newServingSize
     */
    public void adjustServingSize(int newServingSize) {
        recipe.adjustServingSize(newServingSize);
    }

    /**
     * Facilitates the process of the user
     * exporting the recipe
     */
	public void exportRecipe() {
        //TODO: This is Alex's problem
	}

    /**
     * Facilitates the process of the user
     * deleting the recipe
     */
	public void deleteRecipe() {
        if(recipeView.deletionConfirmation()){
            UserController.getUserController().getGlobalUser().getRecipeBook().removeRecipe(recipe);
        }
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

            //set name & create builder
            Recipe.RecipeBuilder rBuild = new Recipe.RecipeBuilder(rBuildView.getRecipeNameFromUser());
            
            //set description
            rBuild.setDescription(rBuildView.getDescriptionFromUser());

            //set serving size
            rBuild.setServingSize(rBuildView.getServingSizeFromUser());

            //set instructions
            rBuild.setInstructions(rBuildView.getInstructionsFromUser());

            //set ingredient list
            rBuild.setIngredientList(rBuildView.getIngredientsFromUser());

            //set categories
            rBuild.setCategories(rBuildView.getCategoriesFromUser());

            //confirm the build
            while(!(rBuildView.confirmBuild())){
                //TODO: What to do if they don't confirm
            }

            //finalizes build and returns recipe
            newRecipe = rBuild.build();
            return newRecipe;
        }
    }

}
