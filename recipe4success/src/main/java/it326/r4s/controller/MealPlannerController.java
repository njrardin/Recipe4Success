package it326.r4s.controller;

import it326.r4s.model.MealPlanner;
import it326.r4s.view.MealPlannerView;
/**
 * Controller for R4S MealPlanner
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class MealPlannerController implements Controller {
    
    private MealPlanner mealPlanner;
    private MealPlannerView mealPlannerView;

    public MealPlannerController(MealPlanner mealPlanner){
        this.mealPlanner = mealPlanner;
        this.mealPlannerView = new MealPlannerView(this);
    }
    
    public void executeView(){
        mealPlannerView.execute();
    }

    public void searchMealPlans() {
        
    }

    public void importMealPlan() {

    }

    public void createMealPlan() {

    }

    public void exportMealPlan() {
    }
}
