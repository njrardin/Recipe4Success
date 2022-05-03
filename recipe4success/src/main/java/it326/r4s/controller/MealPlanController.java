package it326.r4s.controller;


import java.util.ArrayList;

import it326.r4s.model.Meal;
import it326.r4s.model.MealPlan;
import it326.r4s.model.Recipe;
import it326.r4s.model.RecipeBook;
import it326.r4s.view.MealPlanView;
import it326.r4s.view.RecipeBookView;

/**
 * Controller for R4S MealPlan
 * @author Nate Rardin (njrardi@ilstu.edu) and Zach Plattner (zmplatt@ilstu.edu)
 * @date 4/26/22
 */
public class MealPlanController  {

    //*Instance Variables\\
    public MealPlan mealPlan;
    public MealPlanView mealPlanView;

    //*Constructor*\\
    /**
     * Constructor for R4S's MealPlan
     * @param mealPlan - the controller's MealPlan
     */
    public MealPlanController(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
        this.mealPlanView = new MealPlanView(this);
    }

    //*Methods*\\
    /**
     * Getter for the controller's MealPlanView
     * @return the MealPlanView object
     */
    public MealPlanView getMealPlanView() {
        return mealPlanView;
    }

    /**
     * Gets an ArrayList of RecipeControllers associated with all recipes in the mealplan
     * @return the ArrayList of RecipeControllers
     */
    public ArrayList<RecipeController> getRecipeControllers(){
        ArrayList<RecipeController> recipeControllers = new ArrayList<RecipeController>();
        for(Recipe recipe: mealPlan.getRecipes()){
            recipeControllers.add(new RecipeController(recipe));
        }
        return recipeControllers;
    }

    /**
     * Launches the mealPlanView to get a user option selection
     * and then takes the appropriate action
     */
    public void openMealPlan(){
        mealPlanView.displayMealPlan();
        int option;
        while(true){
            option = mealPlanView.getMenuOptionSelection();

            switch (option) {
                case 1:
                    addRecipeToMealPlan();
                    break;
                case 2:
                    removeRecipeFromMealPlan();
                    break;
                case 3:
                    //select recipe
                    openARecipe();
                    break;
                case 4:
                    adjustMealPlanServingSize();
                    break;
                case 5:
                    addToGroceryList();
                    break;
                case 6:
                    exportMealPlan();
                    return;
                case 7:
                    deleteMealPlan();
                    mealPlanView.displayMealPlan();
                    return;
                case 8:
                    return;
                default:
                    System.out.println("Invalid input, please try again\n");
            }
            mealPlanView.displayMealPlan();
        }
    }


    public MealPlan getMealPlan() {
        return this.mealPlan;
    }

    public void addRecipeToMealPlan() {
        RecipeBook recipeBook = UserController.getUserController().getGlobalUser().getRecipeBook();

        System.out.println("Which recipe would you like to add?");
        try{
            RecipeController selectedRecipeController = RecipeBookView.getRecipeSelection(new RecipeBookController(recipeBook).getRecipeControllers());
            mealPlan.addMeal(new Meal(selectedRecipeController.getRecipe(), selectedRecipeController.getRecipe().getServingSize()));
            System.out.println("Recipe added successfully");
        } catch (RuntimeException re) {
            System.out.println("Oops, something went wrong adding the recipe.");
            return;
        }


    }

    public void removeRecipeFromMealPlan() {        
        System.out.println("Which recipe would you like to remove?");

        RecipeController selectedRecipeController = RecipeBookView.getRecipeSelection(getRecipeControllers());

        mealPlan.removeMeal(selectedRecipeController.getRecipe());

        System.out.println("Recipe removed successfully");
    }

    private void openARecipe() {
        System.out.println("Which recipe would you like to open?");

        RecipeController selectedRecipeController = RecipeBookView.getRecipeSelection(getRecipeControllers());
        
        selectedRecipeController.openRecipe();
        System.out.println();
    }

    public void adjustMealPlanServingSize() {
        int servingSize = mealPlanView.getNewServingSize();
        mealPlan.setMealServingSize(servingSize);
    }

    public void exportMealPlan() {
        //TODO - req 17 @Alex!
        //  /\ "Lmao" - Nate
    }

    public void addToGroceryList() {
        UserController.getUserController().getGlobalUser().addMealPlanToGroceryList(mealPlan);
        System.out.println("Ingredients added successfully");
    }

    public void deleteMealPlan() {//req 11
        if(mealPlanView.deletionConfirmation()){
            UserController.getUserController().getGlobalUser().getMealPlanner().removeMealPlan(mealPlan);
        }
    }
}
