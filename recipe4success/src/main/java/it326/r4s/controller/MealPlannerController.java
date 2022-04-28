package it326.r4s.controller;

import it326.r4s.model.MealPlanner;
import it326.r4s.view.MealPlannerView;
/**
 * Controller for R4S MealPlanner
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class MealPlannerController {
    
    private MealPlanner mealPlanner;
    private MealPlannerView mealPlannerView;

    public MealPlannerController(MealPlanner mealPlanner){
        this.mealPlanner = mealPlanner;
        this.mealPlannerView = new MealPlannerView(this);
    }
    
    public void openMealPlanner(){
        mealPlannerView.getMenuOptionSelection();
        //TODO finish
    }

    public void searchMealPlans() {
        //TODO - req 16?
    }

    public void searchForMealPlan() {
        //TODO - req 16?
    }

    public void selectMealPlan() {
        
    }

    public void viewMealPlans() {

    }

    public void importMealPlan() {
        //TODO - req 18
    }

    public void createMealPlan() {
        //TODO - req 10
    }

    public void exportMealPlan() {
        //TODO - req 17
    }
}
