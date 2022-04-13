package it326.r4s;

import java.util.ArrayList;
import java.util.Collection;

import me.xdrop.fuzzywuzzy.*;

public class MealPlanSearch implements CollectionSearch<MealPlan> {
    
    private Collection<MealPlan> mealplans;

    public MealPlanSearch(Collection<MealPlan> mealplans){
        this.mealplans = mealplans;
    }

    @Override
    public ArrayList<MealPlan> searchFor(String searchString) {
        ArrayList<MealPlan> itemsThatPassed = new ArrayList<MealPlan>();
        searchString = searchString.toLowerCase();

        for (MealPlan mealplan: mealplans){
            if(FuzzySearch.partialRatio(searchString, mealplan.getMealPlanName().toLowerCase()) > 75){
                itemsThatPassed.add(mealplan);
            }
            else if(FuzzySearch.partialRatio(searchString, mealplan.getMealPlanDescription().toLowerCase()) > 75){
                itemsThatPassed.add(mealplan);
            }
        }
        return itemsThatPassed;
    }

    public ArrayList<MealPlan> searchRecipesFor(String searchString){
        ArrayList<MealPlan> itemsThatPassed = new ArrayList<MealPlan>();
        searchString = searchString.toLowerCase();

        for (MealPlan mealplan: mealplans){
            RecipeSearch rs = new RecipeSearch(mealplan.getRecipes());

            if ( !(rs.searchFor(searchString).isEmpty())){
                itemsThatPassed.add(mealplan);
            }
        }
        return itemsThatPassed;
    }
}
