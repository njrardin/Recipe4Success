package it326.r4s.controller;

import java.util.ArrayList;

import it326.r4s.model.MealPlan;
import it326.r4s.model.MealPlanner;
import it326.r4s.view.MealPlannerView;
/**
 * Controller for R4S MealPlanner
 * @author Zach Plattner (zmplatt@ilstu.edu)
 * @date 4/26/22
 */
public class MealPlannerController implements CLI_Controller {
    private MealPlanner mealPlanner;
    private MealPlannerView mealPlannerView;

    public MealPlannerController(MealPlanner mealPlanner){
        this.mealPlanner = mealPlanner;
        this.mealPlannerView = new MealPlannerView(this);
    }

    public MealPlanner getMealPlanner() {
        return this.mealPlanner;
    }
    
    public ArrayList<MealPlanController> getMealPlanControllers() {
        ArrayList<MealPlanController> mealPlanControllers = new ArrayList<MealPlanController>();
        for(MealPlan mealPlan: mealPlanner.getMealPlans()){
            mealPlanControllers.add(new MealPlanController(mealPlan));
        }
        return mealPlanControllers;
    }

    public void executeView(){
        mealPlannerView.execute();
    }

    public void markIndMealPlanAsActive() {
        //TODO - req 15
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
