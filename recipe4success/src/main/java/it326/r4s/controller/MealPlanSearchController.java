package it326.r4s.controller;

import java.util.ArrayList;


import it326.r4s.model.MealPlan;
import it326.r4s.model.MealPlanSearch;
import it326.r4s.view.MealPlanSearchView;

/**
 * Controller for R4S MealPlanner
 * @author Zach Plattner (zmplatt@ilstu.edu) and Nate Rardin (njrardi@ilstu.edu)
 * @date 4/29/22
 */
public class MealPlanSearchController {

    //*Instance variables*\\
    private MealPlanSearch mpSearch;
    private MealPlanSearchView mealPlanSearchView;

    //*Constructor*\\
    /**
     * Constructor for R4S's MealPlanSearchController
     * @param mealPlans
     */
    public MealPlanSearchController(ArrayList<MealPlan> mealPlans) {
        mealPlanSearchView = new MealPlanSearchView(this);
        this.mpSearch = new MealPlanSearch(mealPlans);
    }

    /**
     * Accessor for the MealPlanSearchView object
     * @return
     */
    public MealPlanSearchView getMealPlanSearchView() {
        return this.mealPlanSearchView;
    }

    /**
     * Facilitates the user
     * searching through meal plans
     * @return a list of mealplans that meet the search criteria
     */
    public ArrayList<MealPlan> search(){
        return searchFor(mealPlanSearchView.getSearchQuery());
    }

    /**
     * Facilitates searching through the mealplans
     * @param searchQuery - the string to search for
     * @return an ArrayList of mealplans that fit the search parameters
     */
    private ArrayList<MealPlan> searchFor(String searchQuery) {
        return new ArrayList<MealPlan>( mpSearch.searchFor(searchQuery));
    }
}
