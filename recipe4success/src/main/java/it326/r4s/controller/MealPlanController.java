package it326.r4s.controller;

import java.util.ArrayList;

import it326.r4s.model.MealPlan;
import it326.r4s.model.MealPlanner;
import it326.r4s.view.MealPlanView;

/**
 * Controller for R4S MealPlan
 * @author Zach Plattner (zmplatt@ilstu.edu)
 * @date 4/26/22
 */
public class MealPlanController  {

    //*Instance Variables\\
    public MealPlan mealPlan;
    public MealPlanView mealPlanView;

    public MealPlanController(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
        this.mealPlanView = new MealPlanView(this);
    }

    public MealPlanView getMealPlanView() {
        return mealPlanView;
    }

    public void executeView(){
        mealPlanView.execute();
    }

    public void launchMealPlanMenu(){
    
    }
    
    public MealPlan getMealPlan() {
        return this.mealPlan;
    }

    public void addRecipeToMP() {
        //TODO - req 12
    }

    public void removeRecipeFromMP() {
        //TODO - req 13
    }

    public void setMealPlanSS(int newServingSize) { //req 14
        mealPlan.setMealServingSize(newServingSize);
    }

    public void exportMealPlan() {
        //TODO - req 17 @Alex!
    }

    public void addAllIngredientsToGroceryList() {
        //TODO - req 19
    }

    public void deleteMealPlan() {//req 11
        if(mealPlanView.deletionConfirmation()){
            UserController.getUserController().getGlobalUser().getMealPlanner().removeMealPlan(mealPlan);
        }
    }
}
