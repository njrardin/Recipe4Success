package it326.r4s;

import java.util.ArrayList;
import java.util.Collection;

import me.xdrop.fuzzywuzzy.*;

/**
 * An implementation of the CollectionSearch interface. Searches through collections of Recipe objects for various parameters
 * @author Nate Rardin (njrardi@ilstu.edu)
 * @date 4/13/22
 * @dependency depends on the me.xdrop.fuzzywuzzy library for fuzzy string searches
 */
public class MealPlanSearch implements CollectionSearch<MealPlan> {
    
    private Collection<MealPlan> mealplans;

    public MealPlanSearch(Collection<MealPlan> mealplans){
        this.mealplans = mealplans;
    }

    /**
     * Searches for a String and returns an ArrayList of any MealPlans fufilling one of the following search criteria
     * 1) Name has a FuzzySearch partial ratio > 75
     * 2) Description FuzzySearch partial ratio > 75
     * @see https://github.com/xdrop/fuzzywuzzy
     * @param searchString - the string to search MealPlans for
     * @return a collection of objects which are considered to fit the search critera given the searchString
     */
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

    /**
     * Searches for a String and returns an ArrayList of any MealPlans whose recipes fufill the search critera
     * specified in the class Recipe.java of the same package
     * @see it326.r4s.Recipe.java
     * @param searchString - the string to search Mealplan Recipes for
     * @return a collection of MealPlans which are considered to fit the search critera given the searchString
     */
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
