package it326.r4s.controller;

import java.util.ArrayList;


import it326.r4s.model.MealPlan;
import it326.r4s.model.MealPlanSearch;
import it326.r4s.view.MealPlanSearchView;

public class MealPlanSearchController {

    private MealPlanSearch mpSearch;
    private MealPlanSearchView mealPlanSearchView;

    public MealPlanSearchController(ArrayList<MealPlan> mealPlans) {
        MealPlanSearchView mealPlanSearchView = new MealPlanSearchView(this);
        this.mpSearch = new MealPlanSearch(mealPlans);
    }

    public MealPlanSearchView getMealPlanSearchView() {
        return this.mealPlanSearchView;
    }

    public ArrayList<MealPlan> searchFor(String searchQuery) {
        return new ArrayList<MealPlan>( mpSearch.searchFor(searchQuery));
    }

}
