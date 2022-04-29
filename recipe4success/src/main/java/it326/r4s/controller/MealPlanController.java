package it326.r4s.controller;


import java.util.ArrayList;

import it326.r4s.model.MealPlan;
import it326.r4s.model.Recipe;
import it326.r4s.view.MealPlanView;

/**
 * Controller for R4S MealPlan
 * @author Zach Plattner (zmplatt@ilstu.edu) and Nate Rardin (njrardi@ilstu.edu)
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
                    adjustMealPlanServingSize();
                    break;
                case 4:
                    addToGroceryList();
                    break;
                case 5:
                    exportMealPlan();
                    return;
                case 6:
                    deleteMealPlan();
                    mealPlanView.displayMealPlan();
                    return;
                case 7:
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
        //TODO - req 12
    }

    public void removeRecipeFromMealPlan() {
        //TODO - req 13
    }

    public void adjustMealPlanServingSize() {
        //TODO - req 14
    }

    public void exportMealPlan() {
        //TODO - req 17 @Alex!
        //  /\ "Lmao" - Nate
    }

    public void addToGroceryList() {
        //TODO - req 19
    }

    public void deleteMealPlan() {//req 11
        if(mealPlanView.deletionConfirmation()){
            UserController.getUserController().getGlobalUser().getMealPlanner().removeMealPlan(mealPlan);
        }
    }
}
