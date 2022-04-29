package it326.r4s.controller;

import java.util.ArrayList;
import java.util.Collection;

import it326.r4s.model.MealPlan;
import it326.r4s.model.MealPlanner;
import it326.r4s.view.MealPlanSearchView;
import it326.r4s.view.MealPlannerView;
/**
 * Controller for R4S MealPlanner
 * @author Zach Plattner (zmplatt@ilstu.edu) and Nate Rardin (njrardi@ilstu.edu)
 * @date 4/26/22
 */
public class MealPlannerController {
    
    //*Isntance Variables*\\
    private MealPlanner mealPlanner;
    private MealPlannerView mealPlannerView;

    //*Constructor*\\
    /**
     * Constructor for R4S's MealPlannerController
     * @param mealPlanner - the controller's MealPlanner
     */
    public MealPlannerController(MealPlanner mealPlanner){
        this.mealPlanner = mealPlanner;
        this.mealPlannerView = new MealPlannerView(this);
    }

    //*Methods*\\
    /**
     * Getter for the controller's MealPlanner
     * @return the Mealplanner object
     */
    public MealPlanner getMealPlanner(){
        return this.mealPlanner;
    }

    /**
     * Getter for the controller's MealPlannerView
     * @return the MealPlannerView object
     */
    public MealPlannerView getMealPlannerView(){
        return this.mealPlannerView;
    }
    
    /**
     * Gets an ArrayList of MealPlanControllers associated with 
     * all the MealPlans in the mealPlanner
     * @return the ArrayList of MealPlanControllers
     */
    public ArrayList<MealPlanController> getMealPlanControllers() {
        ArrayList<MealPlanController> mealPlanControllers = new ArrayList<MealPlanController>();
        for(MealPlan mealPlan: mealPlanner.getMealPlans()){
            mealPlanControllers.add(new MealPlanController(mealPlan));
        }
        return mealPlanControllers;
    }

    /**
     * Launches the mealPlannerView to get a user option selection
     * and then takes the appropriate action
     */
    public void openMealPlanner(){
        mealPlannerView.displayHeader();
        mealPlannerView.displayMealPlanner();
        int option;
        while (true) {
            option = mealPlannerView.getMenuOptionSelection();
            switch (option) {
                case 1:
                    searchMealPlans();
                    break;
                case 2:
                    importMealPlan();
                    break;
                case 3:
                    exportMealPlan();
                    break;
                case 4:
                    createMealPlan();
                    break;
                case 5:
                    selectMealPlan(mealPlanner.getMealPlans());
                    break;
                case 6:
                    setActiveMealPlan();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid input, please try again\n");
            }
        }
    }

    /**
     * Facilitates the process of the user
     * setting their active MealPlan
     */
    public void setActiveMealPlan() {
        int selection = mealPlannerView.getActivationSelection();
        mealPlanner.setActiveMealPlanIndex(selection - 1);
    }
    
    /**
     * Facilitates the process of the user
     * searching through MealPlans in the mealPlanner
     */
    public void searchMealPlans() {
        MealPlanSearchController mpsController = new MealPlanSearchController(mealPlanner.getMealPlans());
        String searchQuery = new MealPlanSearchView(mpsController).getSearchQuery();
        ArrayList<MealPlan> returnMealPlans = mpsController.searchFor(searchQuery);
        
        selectMealPlan(returnMealPlans);    
    }
    
    /**
     * Facilitates the process of the user
     * importing a MealPlan into the application
     */
    public void importMealPlan() {
        //TODO - req 18
    }

    /**
     * Facilitates the process of the user
     * exporting a MealPlan out of application
     */
    public void exportMealPlan() {
        //TODO - req 17
    }
    
    /**
     * Facilitates the process of the user
     * creating a new MealPlan for the mealPlanner
     */
    public void createMealPlan() {
        mealPlannerView.initCreateMealplan();
        MealPlan newMealPlan = new MealPlan(mealPlannerView.getMealPlanNameFromUser());
        newMealPlan.setMealPlanDescription(mealPlannerView.getMealPlanDescriptionFromUser());

        MealPlanController mpc = new MealPlanController(newMealPlan);

        do{
            mpc.addRecipeToMealPlan();
        } while (mealPlannerView.wantToAddAnotherRecipe());

        mealPlanner.addMealPlan(mpc.getMealPlan());

        System.out.println("You have successfully created the meal plan: \n");
        mpc.getMealPlanView().displayOneline();
        System.out.println();
    }

    /**
     * Facilitates the process of the user
     * selecting one of the MealPlans in the mealPlanner
     */
    public void selectMealPlan(Collection<MealPlan> mealPlans) {
        ArrayList<MealPlanController> mealPlanControllers = new ArrayList<MealPlanController>();
        for(MealPlan mealplan: mealPlans){
            mealPlanControllers.add(new MealPlanController(mealplan));
        }
        try{
            MealPlanController selectedMealplanController = mealPlannerView.getMealPlanSelection(mealPlanControllers);
            selectedMealplanController.openMealPlan();
        } catch (RuntimeException e) { /*do nothing*/ }

    }

}
